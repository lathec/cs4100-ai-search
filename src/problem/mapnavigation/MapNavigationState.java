package problem.mapnavigation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MapNavigationState implements State {
	
	private RomanianCity currentLocation;
	private Integer totalDistanceTravelled;
	
	public MapNavigationState(RomanianCity currentLocation, int totalDistanceTravelled) {
		this.currentLocation        = currentLocation;
	    this.totalDistanceTravelled = totalDistanceTravelled;
	}
	
	public RomanianCity getCurrentLocation() {
		return this.currentLocation;
	}
	
	public Integer getTotalDistanceTravelled() {
		return this.totalDistanceTravelled;
	}

	public boolean equals(Object other) {
		if(other instanceof MapNavigationState) {
			return(((MapNavigationState)other).getCurrentLocation().equals(this.getCurrentLocation()));
		}
		return false;
	}
	
	/**
	 * 
	 * @author Brent Kersanske
	 *
	 */
	public static class RomanianCity {
	
		public static enum Location {ARAD_LOC, BUCHAREST_LOC, CRAIOVA_LOC, DOBRETA_LOC, FAGARAS_LOC, GIURGIU_LOC, LUGOJ_LOC, MEHADIA_LOC, ORADEA_LOC, PITESTI_LOC, RIMNICU_VILCEA_LOC, SIBIU_LOC, TIMISOARA_LOC, ZERIND_LOC};
		
		/* Static maps of distances from one city to its road connected other cities. */
		private static Map<Location, Integer> ARAD_CONNS_DISTS           = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> BUCHAREST_CONNS_DISTS      = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> CRAIOVA_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> DOBRETA_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> FAGARAS_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> GIURGIU_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> LUGOJ_CONNS_DISTS          = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> MEHADIA_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> ORADEA_CONNS_DISTS         = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> PITESTI_CONNS_DISTS        = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> RIMNICU_VILCEA_CONNS_DISTS = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> SIBIU_CONNS_DISTS          = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> TIMISOARA_CONNS_DISTS      = new HashMap<Location, Integer> ();
		private static Map<Location, Integer> ZERIND_CONNS_DISTS         = new HashMap<Location, Integer> ();
		
		/* Populate the list of city connection distances with pre-computed distances in km */
		static {
			ARAD_CONNS_DISTS.put(Location.ZERIND_LOC, 0);
			ARAD_CONNS_DISTS.put(Location.SIBIU_LOC, 0);
			ARAD_CONNS_DISTS.put(Location.TIMISOARA_LOC, 0);
			BUCHAREST_CONNS_DISTS.put(Location.FAGARAS_LOC, 0);
			BUCHAREST_CONNS_DISTS.put(Location.PITESTI_LOC, 0);
			BUCHAREST_CONNS_DISTS.put(Location.GIURGIU_LOC, 0);
			CRAIOVA_CONNS_DISTS.put(Location.DOBRETA_LOC, 0);
			CRAIOVA_CONNS_DISTS.put(Location.RIMNICU_VILCEA_LOC, 0);
			CRAIOVA_CONNS_DISTS.put(Location.PITESTI_LOC, 0);
			DOBRETA_CONNS_DISTS.put(Location.MEHADIA_LOC, 0);
			DOBRETA_CONNS_DISTS.put(Location.CRAIOVA_LOC, 0);
			FAGARAS_CONNS_DISTS.put(Location.SIBIU_LOC, 0);
			FAGARAS_CONNS_DISTS.put(Location.BUCHAREST_LOC, 0);
			GIURGIU_CONNS_DISTS.put(Location.BUCHAREST_LOC, 0);
			LUGOJ_CONNS_DISTS.put(Location.TIMISOARA_LOC, 0);
			LUGOJ_CONNS_DISTS.put(Location.MEHADIA_LOC, 0);
			MEHADIA_CONNS_DISTS.put(Location.LUGOJ_LOC, 0);
			MEHADIA_CONNS_DISTS.put(Location.DOBRETA_LOC, 0);
			ORADEA_CONNS_DISTS.put(Location.ZERIND_LOC, 0);
			ORADEA_CONNS_DISTS.put(Location.SIBIU_LOC, 0);
			PITESTI_CONNS_DISTS.put(Location.RIMNICU_VILCEA_LOC, 0);
			PITESTI_CONNS_DISTS.put(Location.CRAIOVA_LOC, 0);
			PITESTI_CONNS_DISTS.put(Location.BUCHAREST_LOC, 0);
			RIMNICU_VILCEA_CONNS_DISTS.put(Location.SIBIU_LOC, 0);
			RIMNICU_VILCEA_CONNS_DISTS.put(Location.CRAIOVA_LOC, 0);
			RIMNICU_VILCEA_CONNS_DISTS.put(Location.PITESTI_LOC, 0);
			SIBIU_CONNS_DISTS.put(Location.ORADEA_LOC, 0);
			SIBIU_CONNS_DISTS.put(Location.ARAD_LOC, 0);
			SIBIU_CONNS_DISTS.put(Location.RIMNICU_VILCEA_LOC, 0);
			SIBIU_CONNS_DISTS.put(Location.FAGARAS_LOC, 0);
			TIMISOARA_CONNS_DISTS.put(Location.ARAD_LOC, 0);
			TIMISOARA_CONNS_DISTS.put(Location.LUGOJ_LOC, 0);
			ZERIND_CONNS_DISTS.put(Location.ORADEA_LOC, 0);
			ZERIND_CONNS_DISTS.put(Location.ARAD_LOC, 0);			
		}
		
		/* The static list of Romanian cities in use for this problem sample. */
		public static RomanianCity ARAD           = new RomanianCity(Location.ARAD_LOC, ARAD_CONNS_DISTS);
		public static RomanianCity BUCHAREST      = new RomanianCity(Location.BUCHAREST_LOC, BUCHAREST_CONNS_DISTS);
		public static RomanianCity CRAIOVA        = new RomanianCity(Location.CRAIOVA_LOC, CRAIOVA_CONNS_DISTS);
		public static RomanianCity DOBRETA        = new RomanianCity(Location.DOBRETA_LOC, DOBRETA_CONNS_DISTS);
		public static RomanianCity FAGARAS        = new RomanianCity(Location.FAGARAS_LOC, FAGARAS_CONNS_DISTS);
		public static RomanianCity GIURGIU        = new RomanianCity(Location.GIURGIU_LOC, GIURGIU_CONNS_DISTS);
		public static RomanianCity LUGOJ          = new RomanianCity(Location.LUGOJ_LOC, LUGOJ_CONNS_DISTS);
		public static RomanianCity MEHADIA        = new RomanianCity(Location.MEHADIA_LOC, MEHADIA_CONNS_DISTS);
		public static RomanianCity ORADEA         = new RomanianCity(Location.ORADEA_LOC, ORADEA_CONNS_DISTS);
		public static RomanianCity PITESTI        = new RomanianCity(Location.PITESTI_LOC, PITESTI_CONNS_DISTS);
		public static RomanianCity RIMNICU_VILCEA = new RomanianCity(Location.RIMNICU_VILCEA_LOC, RIMNICU_VILCEA_CONNS_DISTS);
		public static RomanianCity SIBIU          = new RomanianCity(Location.SIBIU_LOC, SIBIU_CONNS_DISTS);
		public static RomanianCity TIMISOARA      = new RomanianCity(Location.TIMISOARA_LOC, TIMISOARA_CONNS_DISTS);
		public static RomanianCity ZERIND         = new RomanianCity(Location.ZERIND_LOC, ZERIND_CONNS_DISTS);
		
		private static Map<Location, RomanianCity> cities = new HashMap<Location, RomanianCity> ();
		
		static {
			cities.put(Location.ARAD_LOC, ARAD);
			cities.put(Location.BUCHAREST_LOC, BUCHAREST);
			cities.put(Location.CRAIOVA_LOC, CRAIOVA);
			cities.put(Location.DOBRETA_LOC, DOBRETA);
			cities.put(Location.FAGARAS_LOC, FAGARAS);
			cities.put(Location.GIURGIU_LOC, GIURGIU);
			cities.put(Location.LUGOJ_LOC, LUGOJ);
			cities.put(Location.MEHADIA_LOC, MEHADIA);
			cities.put(Location.ORADEA_LOC, ORADEA);
			cities.put(Location.PITESTI_LOC, PITESTI);
			cities.put(Location.RIMNICU_VILCEA_LOC, RIMNICU_VILCEA);
			cities.put(Location.SIBIU_LOC, SIBIU);
			cities.put(Location.TIMISOARA_LOC, TIMISOARA);
			cities.put(Location.ZERIND_LOC, ZERIND);
		}
		
		private Location location;
		private Map<Location, Integer> connectionDistances;
		
		/**
		 * Constructor.
		 * @param location
		 * @param connectionDistances
		 */
		public RomanianCity(Location location, Map<Location, Integer> connectionDistances) {
			this.location            = location;
			this.connectionDistances = connectionDistances;
		}
		
		public Location getLocationIdentifier() {
			return this.location;
		}
		
		public Set<Location> getConnections() {
			return this.connectionDistances.keySet();
		}
		
		public boolean isConnected(Location connection) {
			return this.connectionDistances.containsKey(connection);
		}	
		
		public Integer getDistanceTo(RomanianCity other) {
			return getDistanceTo(other.getLocationIdentifier());
		}
		
		public Integer getDistanceTo(Location connection) {
			if(isConnected(connection)) {
				return this.connectionDistances.get(connection);
			} else {
				return -1;
			}
		}

		public static RomanianCity getCity(Location location) {
			return cities.get(location);
		}
		
		public boolean equals(Object other) {
			if(other instanceof RomanianCity) {
				return (((RomanianCity)other).getLocationIdentifier().equals(this.getLocationIdentifier()));
			}
			return false;
		}
		
		public String toString() {
			return this.location.name();
		}
	}
}
