
public class Main {

	public static void main(String[] args) {
		key_generator k= new key_generator();
		System.out.println(k.keyToString());
		System.out.println(k.writeKeyFile());
	}
}
