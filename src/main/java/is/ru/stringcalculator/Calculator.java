package is.ru.stringcalculator;

public class Calculator {

  public static int add(String text){
    if(text.startsWith("//")){
      return sum(splitNumbersOnDelim(text));
    }

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

  private static String[] splitNumbersOnDelim(String text){
    String [] getDelim = text.split("\n");
    String delim = getDelim[0].substring(2, 3);
    text = text.substring(getDelim[0].length() + 1, text.length());
    String replace = "\n";
    text = text.replaceAll(replace, delim);
    replace = ",";
    text = text.replaceAll(replace, delim);
    return text.split(delim);
  }

  private static int sum(String[] numbers){
    checkForNeg(numbers);
    int total = 0;
    for(String number : numbers){
      if(checkForHighNum(number)){
        total += toInt(number);
      }
    }
    return total;
  }

  private static boolean checkForHighNum(String number){
    return(toInt(number) <= 1000);
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
