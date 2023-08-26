package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    Gift gift;
    GiftFactory giftFactory;


    @Before
    public void setUp() {
        gift = new Gift("Christmas", 40);
        giftFactory = new GiftFactory();
        giftFactory.createGift(gift);
    }

    @Test
    public void testGtCount() {
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameGiftsShouldThrow() {
        Gift gift1 = new Gift("Christmas", 40);
        giftFactory.createGift(gift1);

    }
    @Test(expected = NullPointerException.class)
    public void  testRemoveGiftNullShouldThrow(){
        giftFactory.removeGift(null);
    }
    @Test(expected = NullPointerException.class)
    public void  testRemoveGiftIsEmptyShouldThrow(){
        giftFactory.removeGift("  ");
    }
    @Test
    public void testRemoveCommand(){
        Gift gift1=new Gift("New Year",50);
        giftFactory.createGift(gift1);
        giftFactory.removeGift("New Year");
        Assert.assertEquals(1,giftFactory.getCount());
    }
    @Test
    public void testGetPresentWithLeastMagic(){
        Gift gift1=new Gift("New Year",50);
        giftFactory.createGift(gift1);
        Assert.assertEquals(gift,giftFactory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresent(){
        Gift gift1=new Gift("New Year",50);
        giftFactory.createGift(gift1);
        Gift actual=giftFactory.getPresent("New Year");
        Assert.assertEquals(gift1,actual);
    }




}
