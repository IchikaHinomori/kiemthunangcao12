
import com.example.kiemthunangcao12.phan2.SanPham;
import com.example.kiemthunangcao12.phan2.SanPhamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SanPhamServiceTest {

    private SanPhamService service;
    private SanPham sanPham;

    @BeforeEach
    public void setUp() {
        service = new SanPhamService();
        // Thêm sẵn một sản phẩm vào danh sách để test sửa
        sanPham = new SanPham("SP001", "San Pham 1", 1, 10000, 10, "Loai 1");
        service.themSanPham(sanPham);
    }

    @Test
    public void testSuaSanPham_ThanhCong() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, 12000, 15, "Loai 2");

        // Act
        service.suaSanPham("SP001", sanPhamMoi);

        // Assert
        SanPham sanPhamSua = service.timSanPhamTheoMa("SP001");
        assertNotNull(sanPhamSua);
        assertEquals("San Pham 1 - Da Sua", sanPhamSua.getTen());
        assertEquals(2, sanPhamSua.getNamBaoHanh());
        assertEquals(12000, sanPhamSua.getGia(), 0.001); // So sánh số thực
        assertEquals(15, sanPhamSua.getSoLuong());
        assertEquals("Loai 2", sanPhamSua.getDanhMuc());
    }

    @Test
    public void testSuaSanPham_MaSanPhamKhongTonTai() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP002", "San Pham 2", 2, 12000, 15, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP002", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_MaSanPhamRong() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP002", "San Pham 2", 2, 12000, 15, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_SanPhamMoiNull() {
        // Arrange

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", null));
    }

    @Test
    public void testSuaSanPham_TenSanPhamRong() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "", 2, 12000, 15, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_TenSanPhamNull() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", null, 2, 12000, 15, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }
    @Test
    public void testSuaSanPham_DanhMucRong() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, 12000, 15, "");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_DanhMucNull() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, 12000, 15, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }
    @Test
    public void testSuaSanPham_NamBaoHanhNhoHon0() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", -1, 12000, 15, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_GiaBang0() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, 0, 15, "Loai 2");
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_GiaNhoHon0() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, -1, 15, "Loai 2");
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }

    @Test
    public void testSuaSanPham_SoLuongNhoHon0() {
        // Arrange
        SanPham sanPhamMoi = new SanPham("SP001", "San Pham 1 - Da Sua", 2, 12000, -1, "Loai 2");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.suaSanPham("SP001", sanPhamMoi));
    }
    @Test
    public void testThemSanPham_MaDaTonTai() {
        SanPham sanPhamTrung = new SanPham("SP001", "Trung Ma", 1, 500f, 2, "Loai A");
        var ex = assertThrows(IllegalArgumentException.class, () -> service.themSanPham(sanPhamTrung));
        assertEquals("Mã sản phẩm SP001 đã tồn tại.", ex.getMessage());
    }
}