package lotto;

import lotto.domain.NumberBox;
import lotto.domain.User;
import lotto.util.Calculator;
import lotto.util.Input;
import lotto.util.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output.printInputMessage();
        int money = Input.readMoney();

        User user = new User(money);
        user.printLottos();

        Output.printInputWinnings();
        List<Integer> winningNumbers = Input.readWinningNumbers();

        Output.printInputBonus();
        int bonusNumber = Input.readBonusNumber();

        NumberBox numberBox = new NumberBox(winningNumbers, bonusNumber);

        Output.printStatistics(
                Calculator.calculateResult(
                        user.getLottos(),
                        numberBox.getWinningNumbers(),
                        numberBox.getBonusNumber()
                )
        );

        Output.printYield(Calculator.calculateYield(money));
    }
}
