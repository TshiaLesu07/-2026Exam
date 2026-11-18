//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);

String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
int[][] sales = new int[3][3];

for (int i = 0; i < names.length; i++){
    for (int a = 0; a < 3; a++){
        System.out.println("Enter number of sales for month " + (a + 1) +
        " for " + names[i] + "matteress: ");
        sales[i][a] = scanner.nextInt();
    }
    System.out.println();
}
}
