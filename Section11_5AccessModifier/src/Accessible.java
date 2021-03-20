/**
 * 1. Interface is accessible package-private
 * 2. int-constant is accessible public
 * 3. methodA public
 * 4. methodB and methodC public
 */
interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
