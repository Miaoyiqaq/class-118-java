package OnlineCalculator;

public class Request {
    private String operator;
    private double num1;
    private double num2;

    public String getOperator() {
        return operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public Request(String operator, double num1, double num2) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
    }
    //构造协议内容
    public  String requestToString() {
        return String.format("%s,%f,%f\n",operator,num1,num2);
    }
    //解析协议内容
    public static Request requestFromString(String request) {
        String[] split = request.split(",");
        String operator = split[0];
        double num1 = Double.parseDouble(split[1]);
        double num2 = Double.parseDouble(split[2]);
        return new Request(operator,num1,num2);
    }


}
