package exception;

// Lớp ngoại lệ khi phi hành gia không hợp lệ
public class InvalidAstronautException extends Exception {
    public InvalidAstronautException(String message) {
        super(message); // Truyền thông báo lỗi vào ngoại lệ
    }
}
