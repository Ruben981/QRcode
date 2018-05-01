package qrporject;


public class Direction {
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locaationOnFloor = null;

	public Direction() {

	}

	
	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocaationOnFloor() {
		return locaationOnFloor;
	}

	public void setLocaationOnFloor(String locaationOnFloor) {
		this.locaationOnFloor = locaationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		
		if (room.length() != ROOM_LENGTH) {			
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {			
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must start with a letter
			}
		}
		if ((room.charAt(0)!='A') && (room.charAt(0)!='B') &&(room.charAt(0)!='C') && (room.charAt(0)!='D') && (room.charAt(0)!='E') && (room.charAt(0)!='F')) {
			return false;
		}
		if ((room.charAt(1)!='0') && (room.charAt(1)!='1') && (room.charAt(1)!='2')) {
			return false;
		}
	
		if ((room.charAt(4)!='3') && (room.charAt(4)!='4') && (room.charAt(4)!='6') && (room.charAt(4)!='7')) {
		return false;
		}
	
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locaationOnFloor = room.substring(2);
		
		return true;
	}
	public boolean onTime(String time) {
		
		
		if ((time.charAt(0) !='0') && (time.charAt(1) != '9')) {  // local hour 09:00
			return false;
		}
		
		return true;
	}
	
	public boolean goodDay(String day) {
		
		if ((day.charAt(0) != 'T') && (day.charAt(1) != 'u')) {   // today day 
			return false;
		}
		return true;
	}
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			// TODO play the sound here for this here
			directions = "From reception, walk straight ahead and then turn to your right";
			break;
		case 'B':
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest";
			break;
		case 'C':
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'D':
			// TODO play the sound here for this here
			directions = "rom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'E':
			// TODO play the sound here for this here
			directions = "From reception, move to centre of the reception and turn left into the engineering building";
			break;
		case 'F':
			// TODO play the sound here for this here
			directions = "From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front";
			break;
		default:
			directions = "Sorry, that building in not recognised";
			break;
			
		}
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':
			// TODO play the sound here for this here
			directions = "Stay on this floor";
			break;
		case '1':
			// TODO play the sound here for this here
			directions = "Ascend the stairs or take the lift to the first floor";			
			break;
		case '2':
			// TODO play the sound here for this here
			directions = "Ascend two flight of stairs or take the lift to the second floor";			
			break;
		default:
			directions = "Sorry, floor " + this.floor + " is not recognised";
			break;
			
		}
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locaationOnFloor) {
		case "006":
			// TODO play the sound here for this here
			directions = "This is a room to the right on this level";
			break;
		case "007":
			// TODO play the sound here for this here
			directions = "This is a room to the right on this level";			
			break;
		case "003":
			// TODO play the sound here for this here
			directions = "This is the last room to the right on this level";			
			break;
		case "004":
			// TODO play the sound here for this here
			directions = "Go to the next to last room to the right on this level";			
			break;
		default:
			directions = "Sorry, that room in not recognised";
			break;
			
		}
		return(directions);
	}

}

