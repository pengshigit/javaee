package cal;

import java.util.Vector;

public class lmail 
{
	public static Vector<String> vsg=new Vector<String>();
	public static Vector<String> nums=new Vector<String>();
	public static Vector<String> chas=new Vector<String>();
	
	public static int num=0;

  static int find2(char a)//zhannei
  {
  if(a=='=')return -2;
  else if(a==')')return -1;
  else if(a=='(')return 4;
  else if(a=='+')return 1;
  else if(a=='-')return 1;
  else if(a=='*')return 2;
  else if(a=='/')return 2;
  return 0;
  }
  static int find(char a)//zhannei
  {
  if(a=='=')return -2;
  else if(a==')')return -1;
  else if(a=='(')return 0;
  else if(a=='+')return 1;
  else if(a=='-')return 1;
  else if(a=='*')return 2;
  else if(a=='/')return 2;
  return 0;
  }

  public static boolean isN(String t)
  {   //System.out.println(t);
	  if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")||t.equals("(")||t.equals(")")||t.equals("="))
		  return false;
	  return true;
  }
	
  static double oper(String s1,String s2,String op)
  {
	 // System.out.println(">>>>"+s1+s2+op);
	  if(op.equals("+"))return Double.valueOf(s1)+Double.valueOf(s2);
	  if(op.equals("-"))return Double.valueOf(s1)-Double.valueOf(s2);
	  if(op.equals("*"))return Double.valueOf(s1)*Double.valueOf(s2);
	  if(op.equals("/"))return Double.valueOf(s1)/Double.valueOf(s2);
	  return 0;
  }
  //public static boolean(char c,char c2)
  {
	//  if(c=='-'&&c2=='-')
  }
public static void main(String[] args)
{
	String name="4/2+2+(5-3+2*6)/(-8/2/2)=";

	//String[] aa = name.split("+|-|=|*|/|(|)");
	int i,j,k;
	//char d = 0;
	StringBuffer d = null ;
	String chg="";
	for(i=0;i<name.length();i++)
	{
		char index=name.charAt(i);
		if(index=='1'||index=='2'||index=='3'||index=='4'||index=='5'||index=='6'
	||index=='7'||index=='8'||index=='9'||index=='0'||index=='.')
		{
			chg+=index;
		}
		else 
		{   char n=0;
			if(i>0)   n=name.charAt(i-1);
			if(i>1&&index=='-'&&(n=='-'||n=='+'||n=='*'||n=='/'||n=='('))
			{  
				chg+=index;
			}
			else if(i==0&&index=='-')
			{
				chg+=index;
			}
			else
			{
			if(chg.length()>0)
			vsg.add(chg);
			chg="";
			vsg.add(""+index);
			}
		}
	}
	System.out.println(vsg);
	
	
	chas.add("=");
	num++;
	int id=0;
	while(id<vsg.size())
	{   
							//System.out.println(id+" "+vsg.get(id));
		if(isN(vsg.get(id)))
		{
			nums.add(vsg.get(id));
		}else
		{  
			while(chas.size()>0&&( //cmpare(chas.lastElement().charAt(0),vsg.get(id).charAt(0))
					find(chas.lastElement().charAt(0))>=find2(vsg.get(id).charAt(0))   
					))    // 4
			{     			// System.out.println("@@@@"+chas.lastElement()+"@@"+vsg.get(id).charAt(0));
							//StringBuffer d2=new StringBuffer(chas.lastElement());  
				String c0=chas.lastElement();
				if(chas.lastElement().charAt(0)=='='&&vsg.get(id).charAt(0)=='=')
					break;
				if(!c0.equals("("))
				{
				int ny=	nums.size();
							//System.out.println(nums);
				double d1=oper(nums.elementAt(ny-2),nums.elementAt(ny-1),chas.lastElement());
							//nums.add(""+chas.lastElement().charAt(0));
				nums.removeElementAt(ny-1);
				nums.removeElementAt(ny-2);
				nums.add(String.valueOf(d1));
							
							//num++;
				}	
				 chas.removeElementAt(chas.size()-1);;
				 //System.out.println(nums+"<<>><"+chas);
				 			//num--;
				if(( vsg.get(id).equals(")") ) && ( c0.charAt(0)=='(' ))
				break;
			}
			
			
			if(!vsg.get(id).equals("=")&&!vsg.get(id).equals(")"))
			 { chas.add(vsg.get(id));   
			 }
		    }
							//System.out.println(nums+"|||||| "+chas);
		id++;
	}
		System.out.println(nums.elementAt(0));
}

}

