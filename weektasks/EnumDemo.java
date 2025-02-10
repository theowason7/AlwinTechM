package weektasks;

enum DaysOfWeek {
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

class EnumDemo {
	    public static void main(String[] args) {
	        DaysOfWeek day = DaysOfWeek.SATURDAY;

	        switch (day) {
	            case SATURDAY:
	            case SUNDAY:
	                System.out.println("Holiday");
	                break;
	            default:
	                System.out.println("Not Holiday");
	        }
	    }

}
