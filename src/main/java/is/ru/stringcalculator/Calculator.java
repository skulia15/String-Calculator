package is.ru.stringcalculator;

public class Calculator {

  public static int add(String text){
  	if(text.equals("")){
  		return 0;
  	}
  	else if(text.contains(",")){
  		return sum(splitNumbers(text));
  	}
  	else
  		return 1;
  }

  private static int toInt(String number){
    return Integer.parseInt(number);
  }

  private static String[] splitNumbers(String numbers){
    String replace = "\n";
    String replaceWith = ",";
    numbers = numbers.replaceAll(replace, replaceWith);
    return numbers.split(",");
  }

  private static int sum(String[] numbers){
    checkForNeg(numbers);
    int total = 0;
    for(String number : numbers){
      total += toInt(number);
    }
    return total;
  }
  private static void checkForNeg(String[] numbers){
    String negatives = createString(numbers);
    if(negatives != ""){
      throw new IllegalArgumentException("Negatives not allowed:" + negatives);
    }
  }
  private static String createString(String[] numbers){
    String negatives = "";
    for(String number : numbers){
      if(toInt(number) < 0){
        if(negatives == ""){
          negatives = " " + number;
        }
        else{
          negatives = negatives + "," + number;
        }
      }
    }
    return negatives;
  }
}
