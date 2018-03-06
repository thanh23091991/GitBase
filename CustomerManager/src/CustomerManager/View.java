package CustomerManager;

import java.util.Scanner;

public class View {
/// change aksdjhadkjashdaksjdhsajk
//
	public static void main(String[] args) {
		String sValue ;
		boolean isValid = false;
		Scanner sc = new Scanner(System.in);
		Controller controller1 = new Controller();
		System.out.println("hello");
		do {
			System.out.println("sửa ");
			System.out.println("Duc commit");
			controller1.TableOfConten();
			System.out.println("Mời nhập lựa chọn:");
			sValue = sc.nextLine();
			byte bResult = controller1.CheckInfo(sValue);
			switch(bResult) {
			case 0:{
				byte bOption = Byte.parseByte(sValue);
				switch(bOption) {
				case 1:{controller1.EnterInfoCustomer();
						isValid = true;};break; 
				case 2:{controller1.ShowInfoCustomer();
				isValid = true;};break; 
				case 3:{controller1.UpdateCustomer();
				isValid = true;};break;
				case 4:{controller1.DeleteCustomer();
				isValid = true;};break;
				case 5:{controller1.SortCustomer();
				isValid = true;}break;
				case 6:{isValid = false;};break;
				}
			};break;
			case 1: System.out.println("- Bạn cần phải nhập vào giá trị."); break;
			case 2: System.out.println("- Giá trị bạn nhập không phải là kiểu số [0-9]."); break;
			case 3: System.out.println("- Giá trị cần nằm trong khoảng [1-6]."); break;
			}
			if(bResult>0)
				isValid = true;	
		}while(isValid);
	}
}
