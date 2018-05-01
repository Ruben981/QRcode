package qrporject;
import java.util.StringTokenizer;

public class Time {
	private String time;
	boolean test=true;

	public Time() {
		
	}
	
	public String get(String data)
	{
		
		// TODO extract the room number eg E2004 from the data passed in
		// Here you write the code to parse the data string and extract the room
		
		StringTokenizer st = new StringTokenizer(data);
		
		while ((st.hasMoreTokens()) && (test)) {
			if(st.nextToken().startsWith("Time")){
				time = st.nextToken(":").trim();
				test=false;
			}
			
		}
		
		return(time);
	}

}