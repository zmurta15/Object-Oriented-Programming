package dronesRUs;

/**
 * Controls the drones that can form swarms
 * 
 * @author Jose Murta & Diogo Ramos
 *
 */
public class GroupDronesClass extends AbstractDrones implements GroupDrones {

	public GroupDronesClass(String droneId, int capacity, int range) {
		super(droneId, capacity, range);
	}
}
