public enum friend {
	vedprakash("great","2002"),
	vipal("strong","2003"),
	kumargaurav("close friend","2003");
	
	private final String desc;
	private final String year_met;
	
	friend(String description,String year){
		desc=description;
		year_met=year;
	}
	public String toString(){
		return String.format("\t%s\t%s\n",desc,year_met);
	}
}