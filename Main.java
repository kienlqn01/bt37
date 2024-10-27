import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    // Hàm nhập số nguyên dương
    public static int nhapSoNguyenDuong() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Nhập một số nguyên dương: ");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Số phải lớn hơn 0. Vui lòng nhập lại.");
            }
        } while (number <= 0);
        return number;
    }

    // Hàm nhập số nguyên
    public static int nhapSoNguyen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        return scanner.nextInt();
    }

    // Hàm nhập mảng số nguyên với n phần tử
    public static int[] nhapMangSoNguyen(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nhapSoNguyen();
        }
        return arr;
    }

    public static void main(String[] args) {
        // Gọi hàm nhapSoNguyenDuong để nhận giá trị n
        int n = nhapSoNguyenDuong();

        // Gọi hàm nhapMangSoNguyen để nhận một mảng a gồm n số nguyên
        int[] a = nhapMangSoNguyen(n);

        // Chuyển mảng a thành đối tượng stream
        IntStream i_stream = Arrays.stream(a);

        // Cách 1: Duyệt stream i_stream theo item và in ra từng item
        System.out.println("Các phần tử trong mảng:");
        i_stream.forEach(item -> System.out.println(item));

        // Phải tạo lại stream vì stream chỉ có thể duyệt một lần
        i_stream = Arrays.stream(a);

        // Cách 2: Duyệt stream i_stream theo chỉ số và in ra từng item với chỉ số
        System.out.println("Các phần tử trong mảng với chỉ số:");
        i_stream.forEachOrdered(item -> {
            int index = Arrays.asList(a).indexOf(item);
            System.out.println("Phần tử thứ " + index + " là: " + item);
        });
    }
}
