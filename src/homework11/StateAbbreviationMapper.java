package homework11;


import java.util.*;

public class StateAbbreviationMapper implements StateAbbreviationService {
	
	private Map<String,String> stateMap;
	
	private String[][] stateArray = {
			{"Alabama", "AL"},
			{ "Alaska",	"AK"},
			{ "Arizona", "AZ"},
			{ "Arkansas","AR"},
			{"California", "CA"},
			{"Colorado",	"CO"}
	};
	
	public StateAbbreviationMapper() {
		stateMap = new HashMap<String, String>();
		//Assume state abbreviation are already in upper case
		for(String[] state: stateArray) {
			stateMap.put(state[0].toUpperCase(), state[1]);
		}	
	}
	
	@Override
	public String findAbbreviation(String stateName) {
		return(stateMap.get(stateName.toUpperCase()));
	}
}
