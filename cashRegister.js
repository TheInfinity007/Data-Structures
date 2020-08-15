let suggest = (amount, counter) => {
  if(amount >= 100 &&  counter['ONE HUNDRED'] > 0){
    return 'ONE HUNDRED'
  }else if(amount >= 20 && counter['TWENTY'] > 0){
    return "TWENTY";
  }else if(amount >= 10 && counter['TEN'] > 0){
    return "TEN";
  }else if(amount >= 5 && counter['FIVE'] > 0){
    return "FIVE";
  }else if(amount >= 1 && counter['ONE'] > 0){
    return "ONE";
  }else{
    return "NONE";
  }
}

let suggestAfterDecimal = (amount, counter) => {
  if(amount >= 25 && counter['QUARTER'] > 0){
    return "QUARTER";
  }else if(amount >= 10 && counter['DIME'] > 0){
    return "DIME";
  }else if(amount >= 5 && counter['NICKEL'] > 0){
    return "NICKEL";
  }else if(amount >= 1 && counter['PENNY'] > 0){
    return "PENNY";
  }else{
    return "NONE";
  }
}

let currency = {
  "PENNY":0.01,
  "NICKEL":0.05,
  "DIME":0.1,
  "QUARTER":0.25,
  "ONE":1,
  "FIVE":5,
  "TEN":10,
  "TWENTY":20,
  "ONE HUNDRED":100
}

function checkCashRegister(price, cash, cid) {
  var change = cash-price;0
  let counter = {};
  cid.forEach((arr)=>{
    counter[arr[0]] = arr[1];
  });

  let amount, preffer, req, val;

  // For number greater than 1
  while(change >= 1){
    preffer = suggest(change, counter);
    if(preffer == 'NONE') break;
    amount = counter[preffer];
    if(amount <= change){
      change = change-amount;
      counter[preffer] = 0;
    }else{      //amount is greater than change
      req = Math.floor(change);
      val = currency[preffer];
      while(req > 0 && req % val != 0){
        req--;
      }
      change = change-req;
      counter[preffer] = amount-req;
    }
  }
  // console.log(change);

  //if change  is less than 1;
  change = parseFloat(change.toFixed(2))*100;
  // console.log(change);
  while(change > 0){
    preffer = suggestAfterDecimal(change, counter);
    amount = counter[preffer]*100;
    if(amount <= change){
      change = change-amount;
      counter[preffer] = 0;
    }else{      //amount is greater than change
      req = change;
      val = currency[preffer]*100;
      while(req > 0 && req % val != 0){
        req--;
      }
      change = change-req;
      counter[preffer] = (amount-req)/100;
    }
    // console.log(preffer, amount, val, req, change);
  }
  // console.log(counter);
  let originalCounter = {};
  cid.forEach((arr)=>{
    originalCounter[arr[0]] = arr[1];
  });
  let differenceCounter = {};
  // console.log(originalCounter);
  // console.log(counter);
  let balance = 0;
  for(let item in counter){
    differenceCounter[item] = parseFloat((originalCounter[item]-counter[item]).toFixed(2));
    balance += parseFloat(counter[item].toFixed(2));
  }
  balance = parseFloat(balance.toFixed(2));
  // console.log(differenceCounter, balance)
  // console.log(original);
  console.log(change);
  if(change > 0){
    let obj = {
      "status": 'INSUFFICIENT_FUNDS', 
      "change":[]
    }
    return obj;
  }
  if(balance == 0){
    let obj = {
      "status": 'CLOSED',
      "change": cid
    }
    console.log(obj);
   return obj;
  }
  let res = [];if(differenceCounter["ONE HUNDRED"] > 0){
    res.push(['ONE HUNDRED', differenceCounter["ONE HUNDRED"]]);
  }if(differenceCounter["TWENTY"] > 0){
    res.push(['TWENTY', differenceCounter["TWENTY"]]);
  }if(differenceCounter["TEN"] > 0){
    res.push(['TEN', differenceCounter["TEN"]]);
  }if(differenceCounter["FIVE"] > 0){
    res.push(['FIVE', differenceCounter["FIVE"]]);
  }if(differenceCounter["ONE"] > 0){
    res.push(['ONE', differenceCounter["ONE"]]);
  }if(differenceCounter["QUARTER"] > 0){
    res.push(['QUARTER', differenceCounter["QUARTER"]]);
  }if(differenceCounter["DIME"] > 0){
    res.push(['DIME', differenceCounter["DIME"]]);
  }if(differenceCounter["NICKEL"] > 0){
    res.push(['NICKEL', differenceCounter["NICKEL"]]);
  }if(differenceCounter["PENNY"] > 0){
    res.push(['PENNY', differenceCounter["PENNY"]]);
  }
  
  let obj = {
    "status": "OPEN",
    "change": res
  }
  console.log(obj);

  return obj;
}
//96.74
// checkCashRegister(3.26, 100, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]])
checkCashRegister(19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);
// checkCashRegister(19.5, 20, [["PENNY", 0.01], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])
// checkCashRegister(19.5, 20, [["PENNY", 0.01], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 1], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])
// checkCashRegister(19.5, 20, [["PENNY", 0.5], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])