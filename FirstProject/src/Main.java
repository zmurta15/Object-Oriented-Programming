
import java.util.Scanner;

import dronesRUs.*;

public class Main {
	private static final String NO_ORDERS_DELIVERED_SO_FAR = "No orders delivered so far!";
	private static final String WILL_DELIVER = " will deliver ";
	private static final String IS_TOO_HEAVY_FOR = " is too heavy for ";
	private static final String IS_TOO_FAR_FOR = " is too far for ";
	private static final String IS_NOT_PENDING = " is not pending!";
	private static final String IS_NOT_AT2 = "is not at ";
	private static final String STRING14 = ":";
	private static final String ORDERS_IN = "Orders in ";
	private static final String THERE_ARE_NO_PENDING_ORDERS_IN = "There are no pending orders in ";
	private static final String STRING13 = "; [";
	private static final String STRING12 = "; ";
	private static final String THERE_ARE_NO_PENDING_ORDERS = "There are no pending orders!";
	private static final String ORDER_QUEUED_FOR_DELIVERY = "Order queued for delivery.";
	private static final String ORDER_DIMENSION_MUST_BE_A_POSITIVE_INTEGER = "Order dimension must be a positive integer!";
	private static final String ORDER = "Order ";
	private static final String TO = " to ";
	private static final String STRING11 = ".";
	private static final String FLYING_FROM = " flying from ";
	private static final String TARGET_BASE = "Target base ";
	private static final String SOURCE_BASE = "Source base ";
	private static final String THERE_ARE_NO_DRONES = "There are no drones!";
	private static final String DISBANDED = " disbanded.";
	private static final String IS_NOT_AT = " is not at ";
	private static final String SWARM_ID = "swarmId =";
	private static final String IS_NOT_A_SWARM = " is not a swarm!";
	private static final String SWARM2 = "Swarm ";
	private static final String STRING10 = "!";
	private static final String CANNOT_ADD_HERMIT_DRONE = "Cannot add hermit drone ";
	private static final String IS_NOT_AVAILABLE_IN_THIS_BASE = " is not available in this base!";
	private static final String TWICE = " twice!";
	private static final String CANNOT_ADD_DRONE = "Cannot add drone ";
	private static final String SWARM_MUST_HAVE_AT_LEAST_TWO_DRONES = "Swarm must have at least two drones!";
	private static final String MOVED_TO_SERVICE_BAY = " moved to service bay.";
	private static final String NO_DRONES_WERE_SENT_TO_THE_SERVICE_STATION = "No drones were sent to the service station!";
	private static final String DOES_NOT_EXIT = " does not exit";
	private static final String STRING9 = "[";
	private static final String SERVICE_BAY = "Service bay:";
	private static final String THE_SERVICE_BAY_IS_EMPTY = "The service bay is empty!";
	private static final String STRING8 = ", ";
	private static final String STRING7 = " ";
	private static final String HANGAR = "Hangar:";
	private static final String THE_HANGAR_IS_EMPTY = "The hangar is empty!";
	private static final String STRING6 = "]";
	private static final String STRING5 = " [";
	private static final String THERE_ARE_NO_BASES = "There are no bases!";
	private static final String CREATED = " created.";
	private static final String INVALID_DRONE_TYPE = "Invalid drone type!";
	private static final String HERMIT = "hermit";
	private static final String SOCIABLE = "sociable";
	private static final String ALREADY_EXISTS = " already exists!";
	private static final String DRONE2 = "Drone ";
	private static final String DOES_NOT_EXIST = " does not exist!";
	private static final String CAPACITY_HAS_TO_BE_A_POSITIVE_INTEGER = "Capacity has to be a positive integer!";
	private static final String INVALID_RANGE_FOR_A_NEW_DRONE = "Invalid range for a new drone!";
	private static final String STRING4 = "].";
	private static final String CREATED_AT = " created at [";
	private static final String STRING3 = ",";
	private static final String BASE2 = "Base ";
	private static final String STRING2 = "]!";
	private static final String THERE_IS_ALREADY_ANOTHER_BASE_AT = "There is already another base at [";
	private static final String BASE_ALREADY_EXISTS = "Base already exists!";
	private static final String EXIT_TERMINATES_THE_EXECUTION_OF_THE_PROGRAM = "exit - terminates the execution of the program";
	private static final String HELP_SHOWS_THE_AVAILABLE_COMMANDS = "help - shows the available commands";
	private static final String TIC_TAC_ADVANCES_THE_SIMULATION_CLOCK_N_TIMESTAMPS = "ticTac - advances the simulation clock n timestamps";
	private static final String IN_TRANSIT_LISTS_ALL_DRONES_AND_SWARMS_CURRENTLY_FLYING = "inTransit - lists all drones (and swarms) currently flying";
	private static final String DELIVERED_LISTS_ALL_DELIVERED_ORDERS = "delivered - lists all delivered orders";
	private static final String DELIVER_DELIVER_A_PACKAGE_TO_A_CUSTOMER = "deliver - deliver a package to a customer";
	private static final String ALL_ORDERS_LISTS_ALL_PENDING_ORDERS_FROM_ALL_BASES = "allOrders - lists all pending orders from all bases";
	private static final String ORDERS_LISTS_ALL_PENDING_ORDERS_FROM_A_BASE = "orders - lists all pending orders from a base";
	private static final String ADD_ORDER_ADD_A_NEW_ORDER_TO_A_BASE = "addOrder - add a new order to a base";
	private static final String FLY_TO_BASE_FLY_A_DRONE_OR_SWARM_TO_A_BASE = "flyToBase - fly a drone (or swarm) to a base";
	private static final String LIST_DRONES_LISTS_ALL_EXISTING_DRONES_AND_SWARMS = "listDrones - lists all existing drones (and swarms)";
	private static final String DISBAND_DISBANDS_THE_WHOLE_SWARM = "disband - disbands the whole swarm";
	private static final String SWARM_COMPONENTS_LISTS_THE_DRONES_WITHIN_A_SWARM = "swarmComponents - lists the drones within a swarm";
	private static final String SWARM_CREATES_A_NEW_SWARM_FROM_FREE_DRONES_IN_A_BASE = "swarm - creates a new swarm from free drones in a base";
	private static final String SERVICE_SERVICE_ALL_GROUNDED_DRONES_REQUIRING_SERVICE_IN_A_BASE = "service - service all grounded drones requiring service in a base";
	private static final String DRONE_REGISTERS_A_NEW_DRONE_IN_A_STARTING_BASE = "drone - registers a new drone in a starting base";
	private static final String LIST_BASES_LISTS_EXISTING_DISTRIBUTION_BASES = "listBases - lists existing distribution bases";
	private static final String STRING = "> ";
	private static final String BYE = "Bye!";
	private static final String UNKNOWN_COMMAND_TYPE_HELP_TO_SEE_AVAILABLE_COMMANDS = "Unknown command. Type help to see available commands.";
	private static final String BASE_REGISTERS_A_NEW_DISTRIBUTION_BASE = "base - registers a new distribution base";
	public static final String EXIT = "EXIT";
	public static final String HELP = "HELP";
	public static final String BASE = "BASE";
	public static final String LIST_BASES = "LISTBASES";
	public static final String DRONE = "DRONE";
	public static final String SERVICE = "SERVICE";
	public static final String SWARM = "SWARM";
	public static final String SWARM_COMPONENTS = "SWARMCOMPONENTS";
	public static final String DISBAND = "DISBAND";
	public static final String LIST_DRONES = "LISTDRONES";
	public static final String FLY_TO_BASE = "FLYTOBASE";
	public static final String ADD_ORDER = "ADDORDER";
	public static final String ORDERS = "ORDERS";
	public static final String ALL_ORDERS = "ALLORDERS";
	public static final String DELIVER = "DELIVER";
	public static final String DELIVERED = "DELIVERED";
	public static final String IN_TRANSIT = "INTRANSIT";
	public static final String TIC_TAC = "TICTAC";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Company comp = new CompanyClass();
		String comm = getCommand(in);
		while (!comm.equals(EXIT)) {
			switch (comm) {
			case HELP:
				help(comp);
				break;
			case BASE:
				base(in, comp);
				break;
			case DRONE:
				drone(in, comp);
				break;

			case LIST_BASES:
				listBases(comp);
				break;

			case SERVICE:
				service(in, comp);
				break;
			case SWARM:
				swarm(in, comp);
				break;
			case LIST_DRONES:
				listDrones(comp);
				break;
			case FLY_TO_BASE:
				flyToBase(in, comp);
				break;
			case ADD_ORDER:
				addOrder(in, comp);
				break;
			case ORDERS:
				orders(in, comp);
				break;
			case ALL_ORDERS:
				allOrders(comp);
				break;
			case DELIVER:
				deliver(in, comp);
				break;
			case DELIVERED:
				delivered(comp);
				break;
			case SWARM_COMPONENTS:
				swarmComponents(in, comp);
				break;
			case DISBAND:
				disband(in, comp);
				break;
			case IN_TRANSIT:
				inTransit(comp);
				break;
			case TIC_TAC:
				ticTac(in, comp);
				break;
			default:
				System.out.println(UNKNOWN_COMMAND_TYPE_HELP_TO_SEE_AVAILABLE_COMMANDS);
			}
			comm = getCommand(in);
		}
		System.out.println(BYE);
		in.close();
	}

	private static String getCommand(Scanner in) {
		System.out.print(STRING);
		String input = in.nextLine().toUpperCase().trim();
		return input;
	}

	/**
	 * Prints the commands available in the program
	 * 
	 * @param comp - The company
	 */
	private static void help(Company comp) {
		System.out.println(BASE_REGISTERS_A_NEW_DISTRIBUTION_BASE);
		System.out.println(LIST_BASES_LISTS_EXISTING_DISTRIBUTION_BASES);
		System.out.println(DRONE_REGISTERS_A_NEW_DRONE_IN_A_STARTING_BASE);
		System.out.println(SERVICE_SERVICE_ALL_GROUNDED_DRONES_REQUIRING_SERVICE_IN_A_BASE);
		System.out.println(SWARM_CREATES_A_NEW_SWARM_FROM_FREE_DRONES_IN_A_BASE);
		System.out.println(SWARM_COMPONENTS_LISTS_THE_DRONES_WITHIN_A_SWARM);
		System.out.println(DISBAND_DISBANDS_THE_WHOLE_SWARM);
		System.out.println(LIST_DRONES_LISTS_ALL_EXISTING_DRONES_AND_SWARMS);
		System.out.println(FLY_TO_BASE_FLY_A_DRONE_OR_SWARM_TO_A_BASE);
		System.out.println(ADD_ORDER_ADD_A_NEW_ORDER_TO_A_BASE);
		System.out.println(ORDERS_LISTS_ALL_PENDING_ORDERS_FROM_A_BASE);
		System.out.println(ALL_ORDERS_LISTS_ALL_PENDING_ORDERS_FROM_ALL_BASES);
		System.out.println(DELIVER_DELIVER_A_PACKAGE_TO_A_CUSTOMER);
		System.out.println(DELIVERED_LISTS_ALL_DELIVERED_ORDERS);
		System.out.println(IN_TRANSIT_LISTS_ALL_DRONES_AND_SWARMS_CURRENTLY_FLYING);
		System.out.println(TIC_TAC_ADVANCES_THE_SIMULATION_CLOCK_N_TIMESTAMPS);
		System.out.println(HELP_SHOWS_THE_AVAILABLE_COMMANDS);
		System.out.println(EXIT_TERMINATES_THE_EXECUTION_OF_THE_PROGRAM);
	}

	/**
	 * Creates a new base in the company
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void base(Scanner in, Company comp) {
		int latitude = in.nextInt();
		int longitude = in.nextInt();
		String baseId = in.nextLine().trim();
		if (comp.sameBaseId(baseId)) {
			System.out.println(BASE_ALREADY_EXISTS);
		} else if (comp.sameBaseCoords(latitude, longitude)) {
			System.out.println(THERE_IS_ALREADY_ANOTHER_BASE_AT + latitude + STRING3 + longitude + STRING2);
		} else {
			comp.registBase(latitude, longitude, baseId);
			System.out.println(BASE2 + baseId + CREATED_AT + latitude + STRING3 + longitude + STRING4);
		}
	}

	/**
	 * Creates a new drone in one specific base
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void drone(Scanner in, Company comp) { // metodo consoante qual seja *ver nota1~
		String droneId = in.nextLine().trim();
		String baseId = in.nextLine();
		String kind = in.next().trim();
		int capacity = in.nextInt();
		int range = in.nextInt();
		in.nextLine();
		if (range < 10) {
			System.out.println(INVALID_RANGE_FOR_A_NEW_DRONE);
		} else if (capacity <= 0) {
			System.out.println(CAPACITY_HAS_TO_BE_A_POSITIVE_INTEGER);
		} else if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIST);
		} else if (comp.sameDroneId(droneId)) {
			System.out.println(DRONE2 + droneId + ALREADY_EXISTS);
		} else if (!((kind.equals(SOCIABLE)) || kind.equals(HERMIT))) {
			System.out.println(INVALID_DRONE_TYPE);
		} else {
			if (kind.equals(HERMIT)) {
				comp.addHermitDrone(baseId, droneId, capacity, range);
			} else {
				comp.addSociableDrone(baseId, droneId, capacity, range);
			}
			System.out.println(DRONE2 + droneId + CREATED);
		}
	}

	/**
	 * Lists the bases, and the drones associated to the bases as well as their
	 * specifications
	 * 
	 * @param comp - the company
	 */
	private static void listBases(Company comp) {
		IteratorBases it = comp.iteratorbases();
		if (!it.hasNext()) {
			System.out.println(THERE_ARE_NO_BASES);
		} else {
			while (it.hasNext()) {
				Bases tmp = it.next();
				System.out.println(
						tmp.getBaseId() + STRING5 + tmp.getLatitude() + STRING3 + tmp.getLongitude() + STRING6);
				IteratorDrones itDrones = comp.iterateDrone(tmp.getBaseId());
				if (!itDrones.hasNext()) {
					System.out.println(THE_HANGAR_IS_EMPTY);
				}
				if (itDrones.hasNext()) {
					System.out.print(HANGAR);
					System.out.print(STRING5);
					while (itDrones.hasNext()) {
						Drones tmp2 = itDrones.next();
						System.out.print(tmp2.getDroneId() + STRING7 + tmp2.capacity() + STRING7 + tmp2.range());
						if (itDrones.hasNext()) {
							System.out.print(STRING8);
						}
					}
					System.out.println(STRING6);
				}
				IteratorDrones itService = comp.iterateServiceDrones(tmp.getBaseId());
				if (!itService.hasNext()) {
					System.out.println(THE_SERVICE_BAY_IS_EMPTY);
				} else {
					while (itService.hasNext()) {
						Drones tmp3 = itService.next();
						System.out.print(SERVICE_BAY);
						System.out.println(STRING9 + tmp3.getDroneId() + STRING7 + tmp3.capacity() + STRING7
								+ tmp3.range() + STRING6);
					}
				}
			}
		}
	}

	/**
	 * Sends the drones to the service bay to restaur their range
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void service(Scanner in, Company comp) {
		String baseId = in.nextLine();
		int capacity = in.nextInt();
		in.nextLine();
		if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIT);
		} else {
			IteratorDrones itDrones = comp.iterateDrone(baseId);
			while (itDrones.hasNext()) {
				Drones tmp = itDrones.next();
				if (tmp.capacity() >= capacity) {
					System.out.println(NO_DRONES_WERE_SENT_TO_THE_SERVICE_STATION);
				} else {
					comp.service(baseId, tmp.getDroneId());
					System.out.println(tmp.getDroneId() + MOVED_TO_SERVICE_BAY);
				}
			}
		}
	}

	/**
	 * Creates a new swarm with some specifics drones
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void swarm(Scanner in, Company comp) {
		String baseId = in.nextLine();
		String swarmId = in.nextLine();
		int nInitialDrones = in.nextInt();
		in.nextLine();
		String[] dronesIds = new String[nInitialDrones];
		for (int i = 0; i < nInitialDrones; i++) {
			dronesIds[i] = in.nextLine();
		}
		int index;

		if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIST);
		} else if (nInitialDrones < 2) {
			System.out.println(SWARM_MUST_HAVE_AT_LEAST_TWO_DRONES);
		} else if ((index = hasTwice(dronesIds, nInitialDrones)) != -1) {
			System.out.println(CANNOT_ADD_DRONE + dronesIds[index] + TWICE);
		} else if ((index = droneNotAvailable(comp, dronesIds, nInitialDrones, baseId)) != -1) {
			System.out.println(DRONE2 + dronesIds[index] + IS_NOT_AVAILABLE_IN_THIS_BASE);
		} else if ((index = addingHermitDrones(comp, baseId, dronesIds, nInitialDrones)) != -1) {
			System.out.println(CANNOT_ADD_HERMIT_DRONE + dronesIds[index] + STRING10);
		} else if (comp.sameDroneId(swarmId)) {
			System.out.println(SWARM2 + swarmId + ALREADY_EXISTS);
		} else {
			comp.newSwarm(swarmId, dronesIds, nInitialDrones, baseId);
			System.out.println(swarmId + CREATED);
		}
	}

	/**
	 * Lists the drones that are inside a specific swarm
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void swarmComponents(Scanner in, Company comp) {
		String swarmId = in.nextLine();
		IteratorBases it1 = comp.iteratorbases();
		if (!comp.sameDroneId(swarmId)) {
			System.out.println(swarmId + IS_NOT_A_SWARM);
		} else {
			int capacity = 0;
			int range = 0;
			double minRange = Double.POSITIVE_INFINITY;
			while (it1.hasNext()) {
				Bases tmp1 = it1.next();
				System.out.println(SWARM_ID + swarmId);
				IteratorDrones it2 = (comp.getBases(tmp1.getBaseId()).getSwarms(swarmId)).swarmComponents();
				while (it2.hasNext()) {
					Drones tmp2 = it2.next();
					capacity = capacity + tmp2.capacity();
					System.out.println(tmp2.getDroneId());
					if (tmp2.range() < minRange) {
						minRange = tmp2.range();
					}
					range = (int) minRange;
					if (!it2.hasNext()) {
						System.out.println(capacity + STRING7 + range);

					}
				}
			}

		}
	}

	/**
	 * Removes the drones that are inside a drone back to the hangar turning to solo
	 * drones again
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void disband(Scanner in, Company comp) {
		String baseId = in.nextLine();
		String swarmId = in.nextLine();
		if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIST);
		} else if (!comp.sameDroneId(swarmId)) {
			System.out.println(swarmId + IS_NOT_AT + baseId + STRING10);
		} else {
			IteratorDrones it = comp.getBases(baseId).getSwarms(swarmId).swarmComponents();
			while (it.hasNext()) {
				Drones tmp = it.next();
				comp.getBases(baseId).removeFromSwarm(tmp.getDroneId());
			}
			comp.getBases(baseId).removeSwarm(swarmId);
			System.out.println(swarmId + DISBANDED);
		}

	}

	/**
	 * Lists all the drones created
	 * 
	 * @param comp - the company
	 */
	private static void listDrones(Company comp) {
		if (!comp.hasDrones()) {
			System.out.println(THERE_ARE_NO_DRONES);
		} else {
			IteratorDrones itDrones = comp.listDrones();
			while (itDrones.hasNext()) {
				Drones tmp = itDrones.next();
				System.out.println(tmp.getDroneId());
			}
		}
	}

	/**
	 * Moves a drone or swarm from the origin base to another base
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void flyToBase(Scanner in, Company comp) {
		String originBase = in.nextLine();
		String droneId = in.nextLine();
		String targetBase = in.nextLine();
		if (!comp.sameBaseId(originBase)) {
			System.out.println(SOURCE_BASE + originBase + DOES_NOT_EXIST);
		} else if (!comp.sameBaseId(targetBase)) {
			System.out.println(TARGET_BASE + targetBase + DOES_NOT_EXIST);
		} else if (!comp.getBases(originBase).sameDroneId(droneId)) {
			System.out.println(droneId + IS_NOT_AT + originBase + STRING10);
		} else {
			Drones tmp = comp.getBases(originBase).getDrone(droneId);
			comp.getBases(targetBase).addDrone(tmp);
			comp.getBases(originBase).removeDrone(tmp.getDroneId());
			System.out.println(droneId + FLYING_FROM + originBase + TO + targetBase + STRING11);
		}
	}

	/**
	 * Adds a new order to one specific base
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void addOrder(Scanner in, Company comp) {
		String originBase = in.nextLine();
		String orderId = in.nextLine();
		int dimension = in.nextInt();
		int latitude = in.nextInt();
		int longitude = in.nextInt();
		in.nextLine();
		if (!comp.sameBaseId(originBase)) {
			System.out.println(SOURCE_BASE + originBase + DOES_NOT_EXIST);
		} else if (comp.getBases(originBase).hasOrder(orderId)) {
			System.out.println(ORDER + orderId + ALREADY_EXISTS);
		} else if (dimension < 0) {
			System.out.println(ORDER_DIMENSION_MUST_BE_A_POSITIVE_INTEGER);
		} else {
			comp.addOrder(originBase, orderId, dimension, latitude, longitude);
			System.out.println(ORDER_QUEUED_FOR_DELIVERY);
		}
	}

	/**
	 * Lists the orders that are in a base
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void orders(Scanner in, Company comp) {
		String baseId = in.nextLine();
		if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIST);
		} else {
			IteratorOrders it = comp.getBases(baseId).initializeOrders();
			if (!it.hasNext()) {
				System.out.println(THERE_ARE_NO_PENDING_ORDERS);
			} else {
				while (it.hasNext()) {
					Orders tmp = it.next();
					System.out.println(tmp.getOrderId() + STRING12 + tmp.getDimension() + STRING13 + tmp.getLatitude()
							+ STRING3 + tmp.getLongitude() + STRING6);
				}
			}

		}
	}

	/**
	 * Lists all the orders from all the bases
	 * 
	 * @param comp - the company
	 */
	private static void allOrders(Company comp) {
		if (!comp.hasOrders()) {
			System.out.println(THERE_ARE_NO_PENDING_ORDERS);
		} else {
			IteratorBases it1 = comp.iteratorbases();
			while (it1.hasNext()) {
				Bases tmp1 = it1.next();
				IteratorOrders it2 = comp.getBases(tmp1.getBaseId()).initializeOrders();
				if (!it2.hasNext()) {
					System.out.println(THERE_ARE_NO_PENDING_ORDERS_IN + tmp1.getBaseId() + STRING11);
				} else {
					System.out.println(ORDERS_IN + tmp1.getBaseId() + STRING14);
					while (it2.hasNext()) {
						Orders tmp2 = it2.next();
						System.out.println(tmp2.getOrderId() + STRING12 + tmp2.getDimension() + STRING13
								+ tmp2.getLatitude() + STRING3 + tmp2.getLongitude() + STRING6);
					}
				}
			}
		}
	}

	/**
	 * Makes a deliver
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void deliver(Scanner in, Company comp) {
		String baseId = in.nextLine();
		String droneId = in.nextLine();
		String orderId = in.nextLine();
		if (!comp.sameBaseId(baseId)) {
			System.out.println(BASE2 + baseId + DOES_NOT_EXIST);
		} else if (!comp.sameDroneId(droneId)) {
			System.out.println(droneId + IS_NOT_AT2 + baseId);
		} else if (!comp.getBases(baseId).hasOrder(orderId)) {
			System.out.println(orderId + IS_NOT_PENDING);
		} else if (comp.calculateDistance(orderId, baseId) > comp.getBases(baseId).getDrone(droneId).range()) {
			System.out.println(orderId + IS_TOO_FAR_FOR + droneId + STRING10);
		} else if (comp.getBases(baseId).getDrone(droneId).capacity() < comp.getBases(baseId).getOrders(orderId)
				.getDimension()) {
			System.out.println(orderId + IS_TOO_HEAVY_FOR + droneId + STRING10);
		} else {
			comp.sendToDelivered(orderId);
			comp.getBases(baseId).sendToInTransit(droneId);
			comp.getBases(baseId).sendToDeliveredOrders(orderId);
			System.out.println(droneId + WILL_DELIVER + orderId + STRING11);
		}
	}

	/**
	 * Lists the delivered orders
	 * 
	 * @param comp - the company
	 */
	private static void delivered(Company comp) {
		IteratorBases it1 = comp.iteratorbases();
		if (!it1.hasNext()) {
			System.out.println(NO_ORDERS_DELIVERED_SO_FAR);
		} else {
			while (it1.hasNext()) {
				Bases tmp1 = it1.next(); // falta tempo
				IteratorOrders it2 = comp.getBases(tmp1.getBaseId()).initializeDeliveredOrders();
				while (it2.hasNext()) {
					Orders tmp2 = it2.next();
					System.out.println(tmp2.getOrderId() + STRING7 + tmp1.getBaseId() + STRING11);
				}
			}
		}
	}

	/**
	 * Lists the drones that are in transit
	 * 
	 * @param comp - the company
	 */
	private static void inTransit(Company comp) {

	}

	/**
	 * Advances the simulation clock n time units
	 * 
	 * @param in   - the scanner
	 * @param comp - the company
	 */
	private static void ticTac(Scanner in, Company comp) {
		int ticTac = in.nextInt();
		in.nextLine();

		for (int i = 0; i < ticTac; i++) {
			IteratorBases it1 = comp.iteratorbases();
			while (it1.hasNext()) {
				Bases tmp1 = it1.next();

				IteratorOrders it2 = comp.getBases(tmp1.getBaseId()).initializeInTransitOrders();
				while (it2.hasNext()) {
					Orders tmp2 = it2.next();
					double distance = comp.calculateDistance(tmp2.getOrderId(), tmp1.getBaseId());
					distance = distance - 10 * ticTac;
					if (distance == 0) {
						comp.sendToDelivered(tmp2.getOrderId());
						comp.getBases(tmp1.getBaseId()).sendToDeliveredOrders(tmp2.getOrderId());
						IteratorDrones it3 = comp.getBases(tmp1.getBaseId()).initializeInTransitDrones();
						while (it3.hasNext()) {
							Drones tmp3 = it3.next();

							comp.getBases(tmp1.getBaseId()).sendToHangar(tmp3.getDroneId());

							if (ticTac >= 3) {
								comp.getBases(tmp1.getBaseId()).sendToHangar(tmp3.getDroneId());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Auxiliar method that checks if the drone is being added twice in a swarm
	 * 
	 * @param dronesIds      - the array that receives the drone's identifier
	 * @param nInitialDrones - the number of initial drones
	 * @return true, if the drone is being added twice; false, otherwise
	 */
	private static int hasTwice(String[] dronesIds, int nInitialDrones) {
		int index = -1;
		for (int i = 0; i < nInitialDrones; i++) {
			for (int j = i + 1; j < nInitialDrones; j++) {
				if (dronesIds[i].equalsIgnoreCase(dronesIds[j])) {
					index = i;

				}
			}
		}
		return index;
	}

	/**
	 * Checks if a drone is available in one specific base
	 * 
	 * @param comp           - the company
	 * @param dronesIds      - the array that receives the drone's identifier
	 * @param nInitialDrones - the number of initial drones
	 * @param baseId         - the base's identifier
	 * @return the index, if the drone is available in the base; -1, otherwise
	 */
	private static int droneNotAvailable(Company comp, String[] dronesIds, int nInitialDrones, String baseId) {
		int index = -1;
		for (int i = 0; i < nInitialDrones; i++) {
			if (!comp.hasDroneAvailableInBase(baseId, dronesIds[i])) {
				index = i;
			}
		}
		return index;
	}

	/**
	 * Checks if there are hermit drones being added to a swarm
	 * 
	 * @param comp           - the company
	 * @param baseId         - the bases identifier
	 * @param dronesIds      - the number of initial drones
	 * @param nInitialDrones - the number of initial drones
	 * @return the index, if the drone being added is hermit; -1 otherwise
	 */
	private static int addingHermitDrones(Company comp, String baseId, String[] dronesIds, int nInitialDrones) {
		int index = -1;
		for (int i = 0; i < nInitialDrones; i++) {
			if (comp.addingHermit(baseId, dronesIds[i])) {
				index = i;
			}
		}
		return index;
	}

}