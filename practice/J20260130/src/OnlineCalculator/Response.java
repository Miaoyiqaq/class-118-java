package OnlineCalculator;

public class Response {
    private double num;

    public Response(double num) {
        this.num = num;
    }

    public String responseToString() {
         return String.format("%f\n",num);
    }
    public static Response responseFromString(String response) {
        return  new Response(Double.parseDouble(response));

    }
    public double getNum() {
        return num;
    }
}
