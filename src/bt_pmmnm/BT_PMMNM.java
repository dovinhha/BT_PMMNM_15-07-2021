/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_pmmnm;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author X509
 */
public class BT_PMMNM {

    public static void main(String[] args) {
        ConnectDatabase conDB = new ConnectDatabase();
        List<SanPham> products = conDB.products();
        header();
        products.forEach(p -> System.out.println(p));
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Nhập thông tin loại sản phẩm cần thêm: ");
        String productTypeName = sc.nextLine();
        conDB.insertProductType(productTypeName);
        List<LoaiSanPham> listProductType = conDB.listProductType();
        System.out.printf("Mã loại SP","Tên Loại SP");
        listProductType.forEach(e-> System.out.println(e));
    }
    public static void header(){
        System.out.printf("Mã SP","Tên SP","NSX","Loại SP");
    }
    
}
