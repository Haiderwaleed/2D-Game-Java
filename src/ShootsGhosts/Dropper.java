package ShootsGhosts;

public class Dropper extends Thread{
	
	GhostLevel gl;
	Ghost[][] ghosts;
	
	Dropper (GhostLevel gl, Ghost[][] ghosts)
	{
		this.ghosts = ghosts;
		this.gl = gl;
	
	}
	 public void run()
	 {
		 while(ghosts [0] [0].getyAxis()<500) 
		 {
			
		 }
		 for(int i = 0;i<ghosts.length;i++)
			{
				for(int j = 0;j<ghosts[i].length;j++)
				{
					ghosts[i][j].setyAxis(ghosts[i][j].getyAxis()+20);
					System.out.println(ghosts[i][j].getyAxis());
			}
		}
		 try {
			Thread.sleep(900); 
		 } catch(Exception e ) {System.out.println(e); }
			gl.repaint();
	   }
   }
