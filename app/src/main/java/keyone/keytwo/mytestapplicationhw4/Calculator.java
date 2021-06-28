package keyone.keytwo.mytestapplicationhw4;

import java.io.Serializable;

public class Calculator implements Serializable {

    private String arithmeticExpression;

    private String result;

    public Calculator() {
        this.arithmeticExpression = "";
        this.result = "";
    }

    public void addNumber(String num) {
        arithmeticExpression = arithmeticExpression.concat(num);
    }

    public void addOperation(String operand){
        int length = arithmeticExpression.length();
        String lastOperation="";
// TBD: to think of processing "." buttonPoint
        if (length == 0)
            arithmeticExpression = "";
        else
            arithmeticExpression = arithmeticExpression.concat(operand);

    }

    public void deleteLast(){
        int length = arithmeticExpression.length();

        //if (!arithmeticExpression.equals("") && !arithmeticExpression.isEmpty()) {
        if (length == 1)
            arithmeticExpression = "";
        else if (length > 1)
            arithmeticExpression = arithmeticExpression.substring(0, length - 1);
    }

    public String getMathExpression() {
        return arithmeticExpression;
    }

    public String getResult() {
//TO DO, currently it's a temporary solution
        result = arithmeticExpression;
        arithmeticExpression = result.concat(" = tbd");
        return arithmeticExpression;
    }
}

