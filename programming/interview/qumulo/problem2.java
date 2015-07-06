class Object {
    int type; // 0: operator, 1: operand
    int value; // for operand only
    int operator; // for operators only.
    // 1: add, 2: minus, 3: multiply, 4: devide.
    public Object (int givenType) {
        this.type = givenType;
    }
}


class Adder {

    public static void main (String[] Args) {
        ArrayList<Object> adderQueue = new ArrayList<Object>();
        int result;
        String in = "+ 1 2";
        getInput(adderQueue, in);
        result = calculate(adderQueue);
        System.out.printf("%d", result);
    }

    public static int calculate(ArrayList<Object> q) {
        int i, partialResult;
        Object newObject;
        while (q.size() != 1) {
            for (i = 0; i < q.size() - 2; i++) {
                if (q[i].type == 0 &&
                        q[i+1].type == 1 &&
                        q[i+2].type == 1) {
                    partialResult = calculateSingle(q, i);
                    q.remove(i);
                    q.remove(i);
                    q.remove(i);
                    newObject = new Object(0);
                    newObject.value = partialResult;
                    q.add(i, newObject);
                }
            }
        }
        return q[0].value;
    }

    public static int calculateSingle(ArrayList<Object> q, int i) {
        int operator = q[i].operator;
        int operand1 = q[i+1].value;
        int operand2 = q[i+2].value;
        if (operator == 1)
            return operand1+operand2;
        if (operator == 2)
            return operand1-operand2;
        if (operator == 3)
            return operand1*operand2;
        if (operator == 4)
            return operand1/operand2;
    }

    public static void getInput(ArrayList<Object> q, String[] in) {
        Object newObject;
        String currString;
        for (int i = 0; i < in.length; i++) {
            currString = in[i];
            if (currString.charAt(0).isDigit()) {
                newObject = new Object(1);
                newObject.value = Integer.parseInt(currString);
            } else {
                newObject = new Object(0); // meaning it's an operator.
                newObject.operator = getOperatorValue(currString.charAt(0));
            }   

            q.add(i, newObject);
        }
    }

    public static int getOperatorValue (char op) {
        if (op == '+')
            return 1;
        if (op == '-')
            return 2;
        if (op == '*')
            return 3;
        if (op == '/')
            return 4;
    }
}
