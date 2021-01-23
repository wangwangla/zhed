//package wk.demo.block.screen;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.scenes.scene2d.Group;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//
//import wk.demo.block.constant.Constant;
//import wk.demo.block.prefab.TempBlock;
//
//public class GameView extends Group {
//    int arr[][];
//
//    public void show(){
//        setSize(Constant.width,Constant.height);
//
//
//
//
//
//
//
//
//
//
//
//
//        int srcx = 4;
//        int srcy = 4;
//        int targetX = 5;
//        int targetY = 4;
//        arr = new int[10][10];
//        arr[srcx][srcy] = 1;
//        arr[targetX][targetY] = 2;
//        TempBlock tempBlock = new TempBlock(arr[i][i1]);
//        addActor(tempBlock);
//        tempBlock.addBlackListener(listener);
//        tempBlock.setPosXY(4,5);
//
//
//
//        addListener(new ClickListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                System.out.println("=======>>>>>>>>>>>>touchDown");
//                return super.touchDown(event, x, y, pointer, button);
//            }
//
//            @Override
//            public void touchDragged(InputEvent event, float x, float y, int pointer) {
//                System.out.println("================>>>>>>>>>>>>>>>touchDragged");
//                super.touchDragged(event, x, y, pointer);
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                super.touchUp(event, x, y, pointer, button);
//                System.out.println("=========>>>>>>>>>>>>>>>touUp");
//            }
//        });
//    }
//
//    public interface BlackListener{
//        public void blackOnClick(int x,int y,int num);
//    }
//
//    private BlackListener listener = new BlackListener() {
//        @Override
//        public void blackOnClick(int x,int y,int num) {
//            //找到上下左右可以走的位置
//            //上
//            int count = 0;
//            for (int i = x;i<10;i++){
//                if (arr[i][y] == 0) {
//                    count++;
//                    show(i,y);
//                }
//                if (count >= num)break;
//            }
//            count = 0;
//            for (int i = x;i>=0;i--){
//                if (arr[i][y] == 0) {
//                    count++;
//                    show(i,y);
//                }
//                if (count >= num)break;
//            }
//            count = 0;
//            for (int i = x;i>=0;i--){
//                if (arr[x][i] == 0) {
//                    count++;
//                    show(x,i);
//                }
//                if (count >= num)break;
//            }
//
//            count = 0;
//            for (int i = x;i<10;i++){
//                if (arr[x][i] == 0) {
//                    count++;
//                    show(x,i);
//                }
//                if (count >= num)break;
//            }
//        }
//    };
//
//    public void show(int x,int y){
//        Image image = new Image(new Texture("white_10x10.png"));
//        addActor(image);
//        image.setPosition(x*50,y*50);
//        image.setSize(10,10);
//    }
//}
//
