
public class StrukturOrganisasi {

    Node root;

    // Add Pegawai Baru
    public boolean tambahPegawai(String namaParent, String namaBaru, String posisi) {
        if (root == null) {
            root = new Node(namaBaru);
            System.out.println("Root telah dibuat: " + namaBaru);
            return true;
        }

        Node parent = cariNode(root, namaParent);
        if (parent == null) {
            System.out.println("Error: Parent '" + namaParent + "' tidak ditemukan.");
            return false;
        }

        if (posisi.equalsIgnoreCase("kiri")) {
            if (parent.left == null) {
                parent.left = new Node(namaBaru);
                System.out.println("Menambahkan " + namaBaru + " sebagai anak kiri dari " + namaParent);
                return true;
            } else {
                System.out.println("Error: Anak kiri dari " + namaParent + " sudah di-isi oleh " + parent.left.nama);
            }
        } else if (posisi.equalsIgnoreCase("kanan")) {
            if (parent.right == null) {
                parent.right = new Node(namaBaru);
                System.out.println("Menambahkan " + namaBaru + " sebagai anak kanan dari " + namaParent);
                return true;
            } else {
                System.out.println("Error: Anak kanan dari " + namaParent + " sudah di-isi oleh " + parent.right.nama);
            }
        } else {
            System.out.println("Error: Posisi harus 'kiri' atau 'kanan'.");
        }
        return false;
    }

    // Cari Node dengan Nama
    private Node cariNode(Node current, String nama) {
        if (current == null) {
            return null;
        }
        if (current.nama.equalsIgnoreCase(nama)) {
            return current;
        }

        Node foundLeft = cariNode(current.left, nama);
        if (foundLeft != null) {
            return foundLeft;
        }

        return cariNode(current.right, nama);
    }

    // Hapus Node + Subtree
    public void hapusPegawai(String nama) {
        if (root == null) {
            System.out.println("Tree kosong.");
            return;
        }
        if (root.nama.equalsIgnoreCase(nama)) {
            root = null;
            System.out.println("Root '" + nama + "' dan seluruh cabangnya telah dihapus.");
            return;
        }

        Node parent = cariParent(root, nama);
        if (parent != null) {
            if (parent.left != null && parent.left.nama.equalsIgnoreCase(nama)) {
                parent.left = null;
            } else if (parent.right != null && parent.right.nama.equalsIgnoreCase(nama)) {
                parent.right = null;
            }
            System.out.println("\nPegawai '" + nama + "' beserta subtree-nya telah dihapus.");
        } else {
            System.out.println("Error: Pegawai '" + nama + "' tidak ada di tree.");
        }
    }

    // Cari Parent dari Node
    private Node cariParent(Node current, String namaAnak) {
        if (current == null) {
            return null;
        }

        if ((current.left != null && current.left.nama.equalsIgnoreCase(namaAnak))
                || (current.right != null && current.right.nama.equalsIgnoreCase(namaAnak))) {
            return current;
        }

        Node foundLeft = cariParent(current.left, namaAnak);
        if (foundLeft != null) {
            return foundLeft;
        }

        return cariParent(current.right, namaAnak);
    }

    // Print Parent 'n Child
    public void cetakHubungan(String nama) {
        Node target = cariNode(root, nama);
        if (target == null) {
            System.out.println("Pegawai '" + nama + "' tidak ditemukan.");
            return;
        }

        System.out.println("\nRelasi dari " + target.nama + ":");

        // Cari Parent
        Node parent = cariParent(root, nama);
        if (parent != null) {
            System.out.println("Atasan (Parent) : " + parent.nama);
        } else {
            System.out.println("Atasan (Parent) : Tidak ada (Ini adalah Direktur/Root)");
        }

        // Cari Child
        System.out.println("Bawahan (Child Kiri)  : " + (target.left != null ? target.left.nama : "-"));
        System.out.println("Bawahan (Child Kanan) : " + (target.right != null ? target.right.nama : "-"));
    }
    public void cetakPreOrder(){
        System.out.println("\nUrutan Pegawai (PreOrder Traversal):");
        preOrderTraversal(root);
        System.out.println();
    }
    private void preOrderTraversal(Node current) {
        if (current != null) {
            System.out.print(current.nama + " ");
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

}
