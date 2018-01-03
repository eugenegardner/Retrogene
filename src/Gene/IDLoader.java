package Gene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IDLoader implements Loader {

	private Map<String, ID> IDHash;
	
	public IDLoader () throws IOException {
		super();
		IDHash = BuildHash();
	}
	
	public Map<String, ID> BuildHash() throws IOException {
		BufferedReader IDReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/Gene/importfiles/ids.txt"), "UTF-8"));
		Map<String, ID> IDHash = new HashMap<String, ID>();
		
		String data[];
		String line;
		
		while ((line = IDReader.readLine()) != null) {
			data = line.split("\t");
			IDHash.put(data[1], new ID(data[1], data[2], data[0], data[3]));
		}
		
		return IDHash;

	}
	
	public ID getID(String dddpID) {

		if (IDHash.containsKey(dddpID)) {
			return IDHash.get(dddpID);
		} else {
			return new ID(null, null, dddpID, null);
		}
		
		
	}
	
	public class ID {
		
		private String dddID;
		private String decipherID;
		private String eugeneID;
		private String stableID;
		
		public ID (String dddID, String decipherID, String eugeneID, String stableID) {
			this.dddID = dddID;
			this.decipherID = decipherID;
			this.eugeneID = eugeneID;
			this.stableID = stableID;
		}

		public String getDddID() {
			return dddID;
		}
		public String getDecipherID() {
			return decipherID;
		}
		public String getEugeneID() {
			return eugeneID;
		}
		public String getStableID() {
			return stableID;
		}
				
	}
	
}
