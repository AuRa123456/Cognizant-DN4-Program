public class ExceptionThrower {
    public void throwException(boolean shouldThrow) throws Exception {
        if (shouldThrow) {
            throw new Exception("Exception was thrown");
        }
    }
}
