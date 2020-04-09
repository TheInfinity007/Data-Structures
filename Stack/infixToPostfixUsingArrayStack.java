import java.util.*;

class Main
{
    static String infixToPostfix(CQStack s, String exp)
    {
        String res = "Yes";
        // for(int i = 0; i < exp.length(); i++)
        // {
        //     char ch = exp.charAt(i);
        //     if(ch == '(')
        //     {
        //         s.push(ch);
        //     }

        //     if((ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= 9))
        //     {
        //         res += ch;
        //     }
        //     else if(ch == ')')
        //     {
        //         ch = (char)s.pop();
        //         while(!(s.isEmpty()) && ch != '(')
        //         {
        //         res += ch;
        //         ch = (char)s.pop();
        //         }
        //     }
    //       else
    //       {
    //         if(!s.isEmpty())
    //         {
    //           s.push(ch);
    //         }
    //         else if(precedence(ch) > precedence((char)s.stackArray[s.top]))
    //           s.push(ch);
    //         else
    //         {
    //           while(!s.isEmpty() && precedence(ch) <= precedence((char)s.stackArray[s.top]))
    //           {
    //             res += (char)s.pop();
    //           }
    //           s.push(ch);
    //         }
    //       }
        return res;
    }
            
    

    public static int precedence(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return 0;
        }
    }

    public static void main(String[] args)
    {
        CQStack theStack = new CQStack(100); // make new stack
        String input = "1\na*(b+c)/d";
        Scanner s=new Scanner(input);
        int t, n, q1, q2;
        String st;
        t = Integer.parseInt(s.nextLine());
        while(t>0)
        {
            st = s.nextLine();
            st = infixToPostfix(theStack, st);
            System.out.println(st);
            t--;
        }
    }
}

class CQStack
{
  public int maxSize; // size of stack array
  public int[] stackArray;
  public int top; // top of stack

  public CQStack(int s) // constructor
  {
    maxSize = s; // set array size
    stackArray = new int[maxSize]; // create array
    top = -1; // no items yet
  }
  public boolean isEmpty() // true if stack is empty
  {
    return (top == -1);
  }
  public boolean isFull() // true if stack is full
  {
    return (top == maxSize-1);
  }

  public void push(int j) // put item on top of stack
  {
    if(isFull())
    {
    }
    else
    {
      stackArray[++top] = j; // increment top, insert item
    }
  }
  public int pop() // take item from top of stack
  {
    if (isEmpty())
    {
      return -1;
    }
    else
    {
      int temp=stackArray[top--];
      return temp; // access item, decrement top
    }
  }
}