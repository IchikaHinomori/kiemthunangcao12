import com.example.kiemthunangcao12.phan1.SoChanLe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoChanLeTest {
    private SoChanLe soChanLe = new SoChanLe();

    @Test
    public void testKiemTraChanLe_SoChanDuong() {
        assertTrue(soChanLe.kiemTraChanLe(2));
    }

    @Test
    public void testKiemTraChanLe_SoChanAm() {
        assertTrue(soChanLe.kiemTraChanLe(-2));
    }

    @Test
    public void testKiemTraChanLe_SoKhong() {
        assertTrue(soChanLe.kiemTraChanLe(0));
    }

    @Test
    public void testKiemTraChanLe_GiaTriBienDuoi() {
        assertTrue(soChanLe.kiemTraChanLe(Integer.MIN_VALUE));
    }

    @Test
    public void testKiemTraChanLe_GiaTriBienTren() {
        assertTrue(soChanLe.kiemTraChanLe(Integer.MAX_VALUE - 1));
    }

    @Test
    public void testKiemTraChanLe_SoLeDuong() {
        assertFalse(soChanLe.kiemTraChanLe(1));
    }

    @Test
    public void testKiemTraChanLe_SoLeAm() {
        assertFalse(soChanLe.kiemTraChanLe(-1));
    }

    @Test
    public void testKiemTraChanLe_SoLeKhac() {
        assertFalse(soChanLe.kiemTraChanLe(3));
    }

    @Test
    public void testKiemTraChanLe_GiaTriBienLe() {
        assertFalse(soChanLe.kiemTraChanLe(Integer.MAX_VALUE));
    }
}
