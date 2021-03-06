package moneyTransfer.techprocess.processPerformers;

import moneyTransfer.messages.OperationResponse;

import java.math.BigDecimal;

public interface AccountOperationHandler {
    OperationResponse transfer(long sourceId, long destinationId, BigDecimal value);
    OperationResponse createNewAccount(BigDecimal initialValue);
    OperationResponse deleteAccount(long id);
}
