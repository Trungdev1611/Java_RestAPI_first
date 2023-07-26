package api.restful.first_app.common;

//public  class ApiResponse {  //việc này tương đương với khai báo record bên dưới
//    private final String message;
//    private final Object data;
//
//    public ApiResponse(String message, Object data) {
//    this.message = message;
//    this.data = data;
//    }
//    public String getMessage() {
//        return this.message;
//    }
//    public Object getData() {
//        return this.data;
//    }
//}
public record ApiResponse(String message, Object data) {
}