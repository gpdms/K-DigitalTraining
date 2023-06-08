package sec12.exam03_import.mycompany;

import sec12.exam03_import.huyndai.Engine;
import sec12.exam03_import.kumho.Tire;
//import단축기 ctrl+shift+o

public class Car {
	Engine engine = new Engine(); //import
//import안쓰면 이렇게 써야함
// sec12.exam03_import.huyndai.Engine engine = new sec12.exam03_import.huyndai.Engine();

	Tire tire = new Tire(); //import 두개 중에 잘 선택


}
