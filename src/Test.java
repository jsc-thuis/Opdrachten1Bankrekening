public class Test {
    public static void main(String[] args) {
        Bankrekening br = new Bankrekening();
        System.out.println(br.isGeldigRekeningNummer("BE71-0961-2345-6769"));  // true
        System.out.println(br.isGeldigRekeningNummer("BE68-5390-0754-7034"));  // true
        System.out.println(br.isGeldigRekeningNummer("BE70-5390-0754-7034"));  // false
        System.out.println(br.isGeldigRekeningNummer("BE11-1111-1111-1111"));  // false
    }
}
