
public class Block { 
	private int startrow;
	private int endrow;
	private int startcol;
	private int endcol;
	
	private int[][] block;
	
	public Block(int [][] block,int rownum,int colnum){
		this.block=block;
		this.startrow=1;
		this.startcol=1;
		this.endrow=rownum;
		this.endcol = colnum;	
	}
	
	public Block(){
		this.block= new int[][]{
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
				{0,0,0,0,0}
		};
		this.startrow = 1;
		this.startcol = 1;
		this.endrow = 3;
		this.endcol = 3;	
	}
	
	public boolean livetonextday(int num)
	{
		if (num==2||num==3)
			return true;	
		else
			return false;
	}
	public boolean deadtonextday(int num)
	{
		if (num==3)
			return true;
		else
			return false;
	}
	
	public int getneibor(int i, int j)
	{
		int num=0;
		for(int k=j-1;k<=j+1;k++)
		{
			num+=block[i-1][k];
		}
		for(int k=j-1;k<=j+1;k++)
		{
			num+=block[i+1][k];
		}
		num+=block[i][j-1];
		num+=block[i][j+1];
		
		return num;	
	}
	
	public int[][] showBlock(int[][] a)
	{
		int [][] b =new int [endrow+2][endcol+2];

		for(int i=startrow;i<=endrow;i++)
			for(int j=startcol;j<=endcol;j++)
			{
				if(a[i][j]==1)
				{
					if(livetonextday(getneibor(i,j)))
						b[i][j]=1;
					else
						b[i][j]=0;
				}				
				else
				{
					if(deadtonextday(getneibor(i,j)))
						b[i][j]=1;
					else
						b[i][j]=0;
				}
			}
		return (int[][])b;
	}
	public static void main(String[] args){
		
		int[][] a = {
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,1,0,0},
				{0,1,0,1,0},
				{0,0,0,0,0}
		};
		
		Block block =new Block(a,3,3);
		int [][] b=block.showBlock(a);
		
		for(int i=0;i<=4;i++){
			for(int j=0;j<=4;j++){
				System.out.print(((int[][])b)[i][j]);
			}
			System.out.println("\n");
		}
				
		
	}
}
