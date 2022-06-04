public class StringToIntegerATOI {

    public int myAtoi(String str) {
                boolean isNegative = false;
                boolean isTrailZero = false;
                boolean isPositiveSignEncountered = false;
                int numStart = -1;
                int numEnd = -1;
                char arr[] = str.toCharArray();
                long res = 0;

                //one pass
                for(int i = 0; i< arr.length; i++){
                    if(arr[i] == 32 ){//empty space
                        if(!isTrailZero && numEnd == -1 && !(isPositiveSignEncountered || isNegative)){
                            //continue only if there is a trailing space
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    else if(arr[i] == 45 && numEnd == -1 && !isTrailZero){

                        if(i-1 >= 0 && (arr[i-1] == 43 || arr[i-1] == 45)){
                            //two signs next to each other
                            return 0;
                        }
                        isNegative = true;
                        //numStart = i+1;
                        //numEnd = numStart;
                    }
                    else if(arr[i] == 43 && numEnd == -1 && !isTrailZero){
                        //positive
                        // numStart = i+1;
                        //numEnd = numStart;

                        if(i-1 >= 0 && (arr[i-1] == 45 || arr[i-1] == 43)){
                            //two signs next to each other
                            return 0;
                        }
                        isPositiveSignEncountered = true;
                    }

                    else if(arr[i] >= 48 && arr[i] <= 57){
                        if(arr[i] == 48 && numEnd == -1){
                            //trailing zero
                            isTrailZero = true;
                            continue;
                        }

                        if(numStart == -1){ //first digit
                            numStart = i;
                            numEnd = numStart;
                            continue;
                        }
                        numEnd++;

                    }else{
                        break;
                    }
                }
                //-1234
                //1234
                //..1234
                //2345
                //second pass

                //42

                if(numStart == -1 && numEnd == -1){
                    //encountered chars as first
                    return 0;
                }
                for(int j = numEnd, k = 0; j>=numStart&&k<= numEnd; j--,k++){

                    try{
                        if(Character.getNumericValue(arr[j]) == 0){
                            // if(k == 0){
                            //     res = 0;
                            // }else{
                            //     res =  (int)Math.pow(10, k);
                            // }
                            continue;
                        }else{
                            res =  Math.multiplyExact(Character.getNumericValue(arr[j]), (int)Math.pow(10, k)) +res;
                        }

                        if(res > Integer.MAX_VALUE ){
                            if(isNegative)
                                return Integer.MIN_VALUE;
                            else
                                return  Integer.MAX_VALUE;
                        }

                    }catch (ArithmeticException e){
                        return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                    }
                }

                //special case for Integer max
//        if(res == -2147483648){
//            if(!isNegative)
//                return Integer.MAX_VALUE;
//            else
//                return res;
//        }

                return isNegative ? (int)res*-1:(int)res;



            }








    public static void main(String[] args){
        int s = (int)Math.ceil(11/5);

        System.out.println(s);
        StringToIntegerATOI atoi =  new StringToIntegerATOI();
        System.out.println(atoi.myAtoi("20000000000000000000"));
    }

}
