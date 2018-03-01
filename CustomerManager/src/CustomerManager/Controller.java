package CustomerManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller {
	Scanner sc = new Scanner(System.in);
	Model model1 = new Model();
	List<Controller> listCustomer = new ArrayList<Controller>();
	public void TableOfConten() {
		System.out.println("--- Table of Content ---");
		System.out.println("1. Nhập thông tin khách hàng?");
		System.out.println("2. Hiển thị danh sách khách hàng?");
		System.out.println("3. Cập nhật thông tin khách hàng?");
		System.out.println("4. Xóa thông tin khách hàng?");
		System.out.println("5. Sắp xếp thông tin khách hàng?"); //buddy sort, insertion sort, selection sort
		System.out.println("6. Thoát chương trình?");
		System.out.println("==> Input?");
	}
	public void Edit() {
		
		System.out.println("Mã khách hàng?");
		model1.RollNo = Integer.parseInt(sc.nextLine());
		System.out.println("Tên khách hàng?");
		model1.FullName =  sc.nextLine();
		System.out.println("Nhập Email?");
		model1.Email = sc.nextLine();
		System.out.println("- Mời nhập điện thoại?");
		model1.Mobile = sc.nextLine();
		System.out.println("- Địa chỉ của khách hàng?");
		model1.Address = sc.nextLine();
	}
	public void EnterInfoCustomer() {
		int n;
		while(true) {
			try {
				System.out.println("Bạn muốn nhập bao nhiêu khách hàng?");
				 n = Integer.parseInt(sc.nextLine());
				 if(n<=0)
					 throw new NumberFormatException();
				break;
			}catch(NumberFormatException e) {
				System.out.println("Bạn cần nhập vào một số nguyên dương");
			}
		}
		for(int i = 0;i<n;i++) {
			//Khai báo một đối tượng chưa thông tin khách hàng
			Controller controller1 = new Controller();
			System.out.println("Khách hàng thứ "+ (i+1));
			controller1.Edit();
			listCustomer.add(controller1);
		}
	}
	public void ShowInfoCustomer() {
		if(listCustomer.size()>0) {
			for(Controller oCust: listCustomer) {
				System.out.println("Mã khách hàng là " + oCust.model1.getRollNo());
				System.out.println("Tên khách hàng là " + oCust.model1.getFullName());
				System.out.println("Hộp thư điện tử là "+ oCust.model1.getEmail());
				System.out.println("Số điện thoại là " + oCust.model1.getMobile());
				System.out.println("Địa chỉ khách hàng là "+ oCust.model1.getAddress());
			}
		}
	}
	public void UpdateCustomer() {
		if(listCustomer.size()>0) {
			int rollno;
			while(true) {
				try {
					System.out.println("Nhập mã khách hàng bạn muốn sửa!");
					rollno = Integer.parseInt(sc.nextLine());
					 if(rollno<=0)
						 throw new NumberFormatException();
					break;
				}catch(NumberFormatException e) {
					System.out.println("Bạn cần nhập vào một số nguyên dương");
				}
			}
			for(Controller oCust: listCustomer) {
				if(rollno == oCust.model1.getRollNo()) {
					listCustomer.get(oCust.model1.getRollNo()).Edit();
				}
			}
		}
	}
	public void DeleteCustomer() {
		if(listCustomer.size()>0) {
			int rollno;
			while(true) {
				try {
					System.out.println("Nhập mã khách hàng bạn muốn sửa!");
					rollno = Integer.parseInt(sc.nextLine());
					 if(rollno<=0)
						 throw new NumberFormatException();
					break;
				}catch(NumberFormatException e) {
					System.out.println("Bạn cần nhập vào một số nguyên dương");
				}
			}
			for(Controller oCust: listCustomer) {
				if(rollno == oCust.model1.getRollNo()) {
					listCustomer.remove(oCust.model1.getRollNo());
				}
			}
		}
	}
	public void SortCustomer() {
		Collections.sort(listCustomer ,(Controller Ct1, Controller Ct2)->{
			if(Ct1.model1.getRollNo()<Ct2.model1.getRollNo())
				return 1;
			else {
				if(Ct1.model1.getRollNo()==Ct2.model1.getRollNo())
					return  0;
				else
					return -1;
			}
		});
	}
	
	static boolean IsEmpty(String sValue) {
		return sValue.isEmpty() ? true : false;
	}

	static boolean IsNumeric(String sValue) {
		return sValue.matches("^[-+]?\\d+(\\.\\d+)?$");
	}

	static boolean IsSatisfy(byte bValue) {
		return (bValue < 1 || bValue > 6) ? false : true;
	}
	static byte CheckInfo(String sValue) {
		if(!IsEmpty(sValue))
			if(IsNumeric(sValue)) {
				byte bValue = Byte.parseByte(sValue);
				if(IsSatisfy(bValue))
					return 0;
				else 
					return 3;				
			}else
				return 2;			
		else 
			return 1;		
	}		
}
