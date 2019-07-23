import java.util.*;
import java.io.*; 
class structure
{
	char ch;
	structure next=null;
}
class structure1
{
	int array[]=new int[4];
	structure1 next=null;
}
class Arraystack
{
	char st[]=new char[1000];
	int index=-1;
	boolean push(char c)
	{
		if(index>=999)
			return false;
		else
		{
			st[++index]=c;
			return true;
		}
	}
	char pop()
	{
		if(index<0)
			return 'q';
		else
			return st[index--];
	}
	void empty()
	{
		index=-1;
	}
}
class Linkedstack
{
	structure head=null;
	boolean push(char c)
	{
		if(head==null)
		{
			head=new structure();
			head.ch=c;
		}
		else
		{
			structure node=new structure();
			node.ch=c;
			node.next=head;
			head=node;
		}
		return true;
	}
	char pop()
	{
		if(head!=null)
		{
			char x=head.ch;
			head=head.next;
			return x;
		}
		else
			return 'q';
	}
	void empty()
	{
		head=null;
	}
}
class Shapestack
{
	structure1 head=null;
	boolean push(int x,int y,int sh,int ver)
	{
		if(head==null)
		{
			head=new structure1();
			head.array[0]=x;
			head.array[1]=y;
			head.array[2]=sh;
			head.array[3]=ver;
		}
		else
		{
			structure1 node=new structure1();
			node.array[0]=x;
			node.array[1]=y;
			node.array[2]=sh;
			node.array[3]=ver;
			node.next=head;
			head=node;
		}
		return true;
	}
	int[] pop()
	{
		if(head!=null)
		{
			int a[]=head.array;
			head=head.next;
			return a;
		}
		else
			return null;
	}
	void empty()
	{
		head=null;
	}
}
class Board
{
	char board[][]=new char[20][20];
	void init()
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if(i==0||j==0||j==19||i==19)
					board[i][j]='*';
				else
					board[i][j]=' ';
			}
		}
	}
	void print()
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
	void fill(Shape s)
	{
		for(int i=0;i<4;i++)
		{
			int x=s.arr[i][0];
			int y=s.arr[i][1];	
			board[x][y]='#';
		}
	}
	void clear(Shape s)
	{
		for(int i=0;i<4;i++)
		{
			int x=s.arr[i][0];
			int y=s.arr[i][1];	
			board[x][y]=' ';
		}
	}
}
class Shape
{
	int x,y;
	int version=1;
	int arr[][]=new int[4][2];
	void corr(){};
}
class Line extends Shape
{
	Line()
	{
		x=2;
		y=(int)(Math.random()*18)+1;
	}
	Line(int a,int b,int c)
	{
		x=a;
		y=b;
		version=c;
	}
	void corr()
	{
		if(version==1)
		{
			arr[0][0]=x-1;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y;
			arr[2][0]=x+1;
			arr[2][1]=y;
			arr[3][0]=x+2;
			arr[3][1]=y;
		}
		else if(version==2)
		{
			arr[0][0]=x;
			arr[0][1]=y-2;
			arr[1][0]=x;
			arr[1][1]=y-1;
			arr[2][0]=x;
			arr[2][1]=y;
			arr[3][0]=x;
			arr[3][1]=y+1;
		}
		else if(version==3)
		{
			arr[0][0]=x-2;
			arr[0][1]=y;
			arr[1][0]=x-1;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y;
			arr[3][0]=x+1;
			arr[3][1]=y;
		}
		else
		{
			arr[0][0]=x;
			arr[0][1]=y-1;
			arr[1][0]=x;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x;
			arr[3][1]=y+2;
		}
	}
	
}
class Lshape extends Shape
{
	Lshape()
	{
		x=2;
		y=(int)(Math.random()*17)+1;
	}
	Lshape(int a,int b,int c)
	{
		x=a;
		y=b;
		version=c;
	}
	void corr()
	{
		if(version==1)
		{
			arr[0][0]=x-1;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y;
			arr[2][0]=x+1;
			arr[2][1]=y;
			arr[3][0]=x+1;
			arr[3][1]=y+1;
		}
		else if(version==2)
		{
			arr[0][0]=x;
			arr[0][1]=y-1;
			arr[1][0]=x;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x+1;
			arr[3][1]=y-1;
		}
		else if(version==3)
		{
			arr[0][0]=x-1;
			arr[0][1]=y-1;
			arr[1][0]=x-1;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y;
			arr[3][0]=x+1;
			arr[3][1]=y;
		}
		else
		{
			arr[0][0]=x-1;
			arr[0][1]=y+1;
			arr[1][0]=x;
			arr[1][1]=y+1;
			arr[2][0]=x;
			arr[2][1]=y;
			arr[3][0]=x;
			arr[3][1]=y-1;
		}
	}
}
class Square extends Shape
{
	Square()
	{
		x=1;
		y=(int)(Math.random()*17)+1;
	}
	Square(int a,int b,int c)
	{
		x=a;
		y=b;
		version=c;
	}
	void corr()
	{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y+1;
			arr[2][0]=x+1;
			arr[2][1]=y;
			arr[3][0]=x+1;
			arr[3][1]=y+1;
	}
	
}
class Zshape extends Shape
{
	Zshape()
	{
		x=2;
		y=(int)(Math.random()*17)+1;
	}
	Zshape(int a,int b,int c)
	{
		x=a;
		y=b;
		version=c;
	}
	void corr()
	{
		if(version==1)
		{
			arr[0][0]=x-1;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x+1;
			arr[3][1]=y+1;
		}
		else if(version==2)
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y+1;
			arr[2][0]=x+1;
			arr[2][1]=y;
			arr[3][0]=x+1;
			arr[3][1]=y-1;
		}
		else if(version==3)
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x-1;
			arr[1][1]=y-1;
			arr[2][0]=x;
			arr[2][1]=y-1;
			arr[3][0]=x+1;
			arr[3][1]=y;
		}
		else
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y-1;
			arr[2][0]=x-1;
			arr[2][1]=y;
			arr[3][0]=x-1;
			arr[3][1]=y+1;
		}
	}
}
class Tshape extends Shape
{
	Tshape()
	{
		x=1;
		y=(int)(Math.random()*16)+2;
	}
	Tshape(int a,int b,int c)
	{
		x=a;
		y=b;
		version=c;
	}
	void corr()
	{
		if(version==1)
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x;
			arr[1][1]=y-1;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x+1;
			arr[3][1]=y;
		}
		else if(version==2)
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x-1;
			arr[1][1]=y;
			arr[2][0]=x+1;
			arr[2][1]=y;
			arr[3][0]=x;
			arr[3][1]=y-1;
		}
		else if(version==3)
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x-1;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x;
			arr[3][1]=y-1;
		}
		else
		{
			arr[0][0]=x;
			arr[0][1]=y;
			arr[1][0]=x-1;
			arr[1][1]=y;
			arr[2][0]=x;
			arr[2][1]=y+1;
			arr[3][0]=x+1;
			arr[3][1]=y;
		}
	}
}
class Tetris
{
	static char key='s';
	static Scanner sc=new Scanner(System.in);
	static Board b=new Board();
	static int count[]=new int[20];
	static Linkedstack undo=new Linkedstack();
	static Linkedstack redo=new Linkedstack();
	static Shapestack shapeundo=new Shapestack();
	static Shapestack shaperedo=new Shapestack();
	static int shape;
	static void clearConsole()
    {
        try
        {	
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){}
    }
	static void fun(Shape l)
	{
		l.corr();
		int obstacle=0;
		b.fill(l);
		b.print();
		while(obstacle!=1)
		{
			key=sc.next().charAt(0);
			if(key=='w')
			{
				if(l.version>3)
					l.version=1;
				else
					l.version++;	
				b.clear(l);	
				l.corr();
				int flag=0;
				for(int i=0;i<4;i++)
				{
					if(l.arr[i][0]>18||l.arr[i][0]<1||l.arr[i][1]>18||l.arr[i][1]<1||b.board[l.arr[i][0]][l.arr[i][1]]!=' ')
					{
						if(l.version==1)
							l.version=4;
						else
							l.version--;
						l.corr();
						flag=1;
					}
				}
				if(flag==0)
				{
					undo.push(key);
					redo.empty();
					shaperedo.empty();
					for(int i=0;i<4;i++)
					{
						if(b.board[l.arr[i][0]+1][l.arr[i][1]]!=' ')
							obstacle=1;
					}
				}
			}		
			else if(key=='s')
			{
				undo.push(key);
				redo.empty();
				shaperedo.empty();
				b.clear(l);
				++l.x;
				l.corr();
				if(b.board[l.arr[0][0]+1][l.arr[0][1]]!=' '||b.board[l.arr[1][0]+1][l.arr[1][1]]!=' '||b.board[l.arr[2][0]+1][l.arr[2][1]]!=' '||b.board[l.arr[3][0]+1][l.arr[3][1]]!=' ')
					obstacle=1;
			}
			else if(key=='a')
			{
				b.clear(l);
				if(b.board[l.arr[0][0]][l.arr[0][1]-1]==' '&&b.board[l.arr[1][0]][l.arr[1][1]-1]==' '&&b.board[l.arr[2][0]][l.arr[2][1]-1]==' '&&b.board[l.arr[3][0]][l.arr[3][1]-1]==' ')
				{
					undo.push(key);
					redo.empty();
					shaperedo.empty();
					--l.y;
					l.corr();
					if(b.board[l.arr[0][0]+1][l.arr[0][1]]!=' '||b.board[l.arr[1][0]+1][l.arr[1][1]]!=' '||b.board[l.arr[2][0]+1][l.arr[2][1]]!=' '||b.board[l.arr[3][0]+1][l.arr[3][1]]!=' ')
						obstacle=1;
				}
			}
			else if(key=='d')
			{
				b.clear(l);
				if(b.board[l.arr[0][0]][l.arr[0][1]+1]==' '&&b.board[l.arr[1][0]][l.arr[1][1]+1]==' '&&b.board[l.arr[2][0]][l.arr[2][1]+1]==' '&&b.board[l.arr[3][0]][l.arr[3][1]+1]==' ')
				{
					undo.push(key);
					redo.empty();
					shaperedo.empty();
					++l.y;
					l.corr();
					if(b.board[l.arr[0][0]+1][l.arr[0][1]]!=' '||b.board[l.arr[1][0]+1][l.arr[1][1]]!=' '||b.board[l.arr[2][0]+1][l.arr[2][1]]!=' '||b.board[l.arr[3][0]+1][l.arr[3][1]]!=' ')
						obstacle=1;
				}
			}
			else if(key=='u')
			{
				char u=undo.pop();
				if(u!='q')
				{
					redo.push(u);
					b.clear(l);
					if(u=='s')
					{
						l.x--;
						l.corr();
					}
					else if(u=='a')
					{
						l.y++;
						l.corr();
					}
					else if(u=='d')
					{
						l.y--;
						l.corr();
					}
					else if(u=='w')
					{
						if(l.version==1)
							l.version=4;
						else
							l.version--;
						l.corr();
					}
					else if(u=='c')
					{
						int arr[]=shapeundo.pop();
						if(arr!=null)
						{
							clearConsole();
							shaperedo.push(l.x,l.y,shape,l.version);
							shape=arr[2];
							if(arr[2]==1)
							{
								Line v=new Line(arr[0],arr[1],arr[3]);
								fun(v);
							}
							else if(arr[2]==2)
							{
								Lshape L=new Lshape(arr[0],arr[1],arr[3]);
								fun(L);
							}
							else if(arr[2]==3)
							{
								Square s=new Square(arr[0],arr[1],arr[3]);
								fun(s);
							}
							else if(arr[2]==4)
							{
								Zshape z=new Zshape(arr[0],arr[1],arr[3]);
								fun(z);
							}
							else
							{
								Tshape t=new Tshape(arr[0],arr[1],arr[3]);
								fun(t);
							}
						}
					}
				}
			}
			else if(key=='r')
			{
				char r=redo.pop();
				if(r!='q')
				{
					undo.push(r);
					if(r=='s')
					{
						b.clear(l);
						l.x++;
						l.corr();
					}
					else if(r=='a')
					{
						b.clear(l);
						l.y--;
						l.corr();
					}
					else if(r=='d')
					{
						b.clear(l);
						l.y++;
						l.corr();
					}
					else if(r=='w')
					{
						b.clear(l);
						if(l.version==4)
							l.version=1;
						else
							l.version++;
						l.corr();
					}
					else if(r=='c')
					{
						int arr[]=shaperedo.pop();
						if(arr!=null)
						{
							clearConsole();
							shapeundo.push(l.x,l.y,shape,l.version);
							shape=arr[2];
							if(arr[2]==1)
							{
								Line v=new Line(arr[0],arr[1],arr[3]);
								fun(v);
							}
							else if(arr[2]==2)
							{
								Lshape L=new Lshape(arr[0],arr[1],arr[3]);
								fun(L);
							}
							else if(arr[2]==3)
							{
								Square s=new Square(arr[0],arr[1],arr[3]);
								fun(s);
							}
							else if(arr[2]==4)
							{
								Zshape z=new Zshape(arr[0],arr[1],arr[3]);
								fun(z);
							}
							else
							{
								Tshape t=new Tshape(arr[0],arr[1],arr[3]);
								fun(t);
							}
						}
					}
				}
			}
			clearConsole();
			b.fill(l);
			if(obstacle==0)
				b.print();
			else
			{
				shapeundo.push(l.x,l.y,shape,l.version);
				undo.push('c');
				for(int i=0;i<4;i++)
				{
					count[l.arr[i][0]]++;
					if(count[l.arr[i][0]]==18)
					{
						for(int j=l.arr[i][0];count[j]!=0;j--)
						{
							for(int z=1;z<19;z++)
								b.board[j][z]=b.board[j-1][z];
							count[j]=count[j-1];
						}
					}
				}
			}
		}
	}
	public static void main(String args[])
	{
		b.init();
		while(key!='q')
		{
			shape=(int)(Math.random()*5)+1;
			if(shape==1)
			{
				Line l=new Line();
				fun(l);
			}
			else if(shape==2)
			{
				Lshape L=new Lshape();
				fun(L);
			}
			else if(shape==3)
			{
				Square s=new Square();
				fun(s);
			}
			else if(shape==4)
			{
				Zshape z=new Zshape();
				fun(z);
			}
			else
			{
				Tshape t=new Tshape();
				fun(t);
			}
		}						
	}
}