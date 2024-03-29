package api.endpoints;

public class Routes {
	
	//Comments....
	public static String base_url = "https://petstore.swagger.io/v2/";

	//User Module
	
	public static String post_url = base_url+"user";
	public static String get_url = base_url+"user/{username}";
	public static String update_url = base_url+"user/{username}";
	public static String delete_url = base_url+"user/{username}";
	
	//Pet Module
	
	public static String get_pet_url=base_url+"pet/{id}";
	
	//Store Module
	
	public static String get_Store_url= base_url+"store/inventory";

}
