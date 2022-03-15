import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commission_default() {
        val currentTransfer = 5_000_00

        val result = commission(currentTransfer = currentTransfer)

        assertEquals(0 ,result)
    }
    @Test
    fun commission_maxTransfer_VK_Pay() {
        val previousTransfers = 0
        val currentTransfer = 16_000_00
        val paymentMethod = PaymentMethod.VK_PAY

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(-1 ,result)
    }
    @Test
    fun commission_maxTotalTransfers_VK_Pay() {
        val previousTransfers = 39_000_00
        val currentTransfer = 2_000_00
        val paymentMethod = PaymentMethod.VK_PAY

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(-1 ,result)
    }
    @Test
    fun commission_maxTransfer() {
        val previousTransfers = 0
        val currentTransfer = 151_000_00
        val paymentMethod = PaymentMethod.MIR

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(-1 ,result)
    }
    @Test
    fun commission_maxTotalTransfers() {
        val previousTransfers = 599_000_00
        val currentTransfer = 2_000_00
        val paymentMethod = PaymentMethod.MIR

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(-1 ,result)
    }
    @Test
    fun commission_maestroCommission() {
        val previousTransfers = 50_001_00
        val currentTransfer = 25_000_00
        val paymentMethod = PaymentMethod.MAESTRO

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(170_00 ,result)
    }
    @Test
    fun commission_maestroNoCommission() {
        val previousTransfers = 50_000_00
        val currentTransfer = 25_000_00
        val paymentMethod = PaymentMethod.MAESTRO

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(0 ,result)
    }
    @Test
    fun commission_mirCurrentCommission() {
        val previousTransfers = 10_000_00
        val currentTransfer = 5_000_00
        val paymentMethod = PaymentMethod.MIR

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(37_50 ,result)
    }
    @Test
    fun commission_mirMinimalCommission() {
        val previousTransfers = 10_000_00
        val currentTransfer = 3_000_00
        val paymentMethod = PaymentMethod.MIR

        val result = commission(
            currentTransfer = currentTransfer,
            paymentMethod = paymentMethod,
            previousTransfers = previousTransfers
        )

        assertEquals(35_00 ,result)
    }
}