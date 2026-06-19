
public class Main {

    public static void main(String[] args) {
        StrukturOrganisasi tree = new StrukturOrganisasi();

        // Base Tree dari Study Case
        tree.tambahPegawai(null, "Direktur", ""); // (Root-nya)
        tree.tambahPegawai("Direktur", "ManagerA", "kiri");
        tree.tambahPegawai("Direktur", "ManagerB", "kanan");
        tree.tambahPegawai("ManagerA", "Staff1", "kiri");
        tree.tambahPegawai("ManagerA", "Staff2", "kanan");
        tree.tambahPegawai("ManagerB", "Staff3", "kiri");
        
        //Preorder
        tree.cetakPreOrder();

        // MENAMBAHKAN: Tampilkan urutan pegawai menggunakan Inorder Traversal
        tree.cetakInOrder();

        //Cetak postorder
        tree.cetakPostOrder();

        // Contoh: Print Parent 'n Child
        tree.cetakHubungan("ManagerA");
        tree.cetakHubungan("Staff3");

        // Contoh: Hapus Node
        tree.hapusPegawai("ManagerB");



    }
}
