package lotto.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.InputConsole;
import lotto.Lotto;
import lotto.enums.ErrorType;

public class CheckInput {

    public static void checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage());
        }

        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage());
        }
    }

    public static Lotto checkLottoNumbers(String inputLottoNumbers){
        String[] splitInputLottoNumbers = inputLottoNumbers.split(",");

        List<Integer> tmpLottoNumber = new ArrayList<>();
        for (String splitInputLottoNumber : splitInputLottoNumbers) {
            try{
                int tmpNumber = Integer.parseInt(splitInputLottoNumber.trim());

                if(tmpNumber < 1 || tmpNumber > 45){
                    throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
                }

                tmpLottoNumber.add(tmpNumber);
            } catch (Exception e){
                throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER_FORMAT.getErrorMessage());
            }
        }

        Collections.sort(tmpLottoNumber);
        Lotto tmpLotto = new Lotto(tmpLottoNumber);

        return tmpLotto;
    }

}
