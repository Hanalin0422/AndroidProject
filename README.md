<h1> AndroidProject - 오늘의 음식 </h1>

## 1. 앱 개발 목적
> 오늘 하루 무엇을 먹을지 고민하는 사람들을 위해 원하는 테마를 선택하면 각 테마별로 오늘 무엇을 	먹을지 음식을 추천해준다. 또한 음식을 만드는 레시피를 제공하고 그 음식에 걸맞는 음료를 추천해주면	서 가까운 편의점을 알려주어 어디서 재료들을 구매하면 좋을지 정보를 제공해준다. 후에 마음에 	드는 음식이 있다면 저장하여 음식 이름을 저장할 수 있다.
>> 사용 대상자 : 오늘 무엇을 먹을지 고민하는사람들

## 2. 시스템 구성
### 2.1 앱을 구성하는데 사용한 언어와 프로그램
```
> 언어 : JAVA
> 데이터베이스 : Firebase
> 프로그램 : 안드로이드스튜디오
```
### 2.2 구현한 기능들
```
1. 필터링 기능 - ArrayList<String> list = new ArrayList<>(Arrays.asList()) 이용
2. 랜덤 기능 - Collections.shuffle() 이용
3. 북마크를 통해 레시피 저장 기능 (데이터 베이스 연동) - recyclerView와 Firebase 이용
4. 구글 API 
```

### 2.3 앱 화면들
#### 2.3.1 초기 화면
<img src = "https://user-images.githubusercontent.com/78638427/144746491-791cbd1e-31e6-42db-b695-2d22c4b52585.png" width = "270" height="480">
스플래쉬로 1초동안 아이콘을 띄워주었다.

```
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceStare){
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
```

***

#### 2.3.2 MainActivity 화면
<img src = "https://user-images.githubusercontent.com/78638427/144747143-f92a367f-346f-44f3-ae31-09e1ce63918a.png" width = "270" height="480">

```
final ArrayList<String> postData = new ArrayList<String>(10);
```
이렇게 checkbox로 입력받은 것들을 ArrayList를 선언해서 담았다.

```
cabbage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cabbage.isChecked() == true){
                    postData.add("양배추");
                }else{
                    postData.remove("양배추");
                }
            }
        });     
```
담는 거는 그냥 이런 식으로 일일이 다 담고 빼줄건 빼주었다.</br>
그 다음에 정보는 intent로 putExtra("name", 보내줄 데이터) 해서 원하는 클래스로 정보를 보내주었다.
```
 noEatSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryChoice.class);
                intent.putExtra("noEat", postData);
                startActivity(intent);
            }
        });
```

***

#### 2.3.3 CategoryChoice 화면
테마는 총 3개로 잡았고 여기서 테마 중 원하는 거 하나 선택하면 그 테마에 맞는 음식을 랜덤으로 보여주는 화면으로 넘어가게 된다.
<img src = "https://user-images.githubusercontent.com/78638427/144747421-4a1448cc-76ef-4e92-97bc-70d40f3c663a.png" width = "270" height="480"></br>
여기서 MainActivity에서 넘어온 ArrayList로 가지고 있는 레시피들을 필터링해서 랜덤으로 보여주어야 하는데 이 기능을 구현하는 것이 어려웠다. </br>
처음에는 안드로이드스튜디오에 내장되어있는 SQLite를 사용하여 삽질 엄청 하다가 안되서 데이터베이스를 이용해서 기능을 구현하는 것은 포기하고 다른 방식을 선택했다. </br>



##### 필터링
```
String[] count1 = {"1", "2", "3", "4", "5"};
    String[] count2 = {"1", "2", "3", "4", "5"};
    String[] count3 = {"1", "2", "3", "4", "5"};
    ArrayList<String> list1 = new ArrayList<>(Arrays.asList(count1));
    ArrayList<String> list2 = new ArrayList<>(Arrays.asList(count2));
    ArrayList<String> list3 = new ArrayList<>(Arrays.asList(count3));
```
이렇게 먼저 테마가 3개니까 3개의 ArrayList<String>을 선언한다. </br>
String 배열을 선언해놓고 다시 ArrayList로 만든 이유는 ArrayList가 값을 덮어씌우기 편했기 때문이었다.
```
final ArrayList<String> noEat = (ArrayList<String>)intent.getSerializableExtra("noEat");
```
일단 이렇게 못 먹는거 checkbox로 체크한거 getExtra로 받아준다.</br>
그리고 난후
```
for(int i=0; i<noEat.size(); i++){
            if(noEat.get(i).equals("돼지고기") || noEat.get(i).equals("양배추")){
                list1.set(2, "7");
            }
            if(noEat.get(i).equals("깻잎") || noEat.get(i).equals("돼지고기") || noEat.get(i).equals("양배추")){
                list1.set(3, "7");
            }
            if(noEat.get(i).equals("계란") || noEat.get(i).equals("김치")){
                list1.set(4, "7");
            }
        }
        list1.removeAll(Arrays.asList(String.valueOf("7")));
```
이렇게 못 먹는 배열들을 비교하여 못 먹는 재료들을 가진 음식들의 index를 아무 숫자 "7"로 덮어씌워주었다. (다른 숫자를 써도 상관 없다. 어차피 다 지울거니까) </br>
그리고나서 list.removeAll()을 이용해서 덮어쓴 String을 지워주면 내가 먹을 수 있는 음식들만 보여줄 수 있는 것이다.


##### 랜덤으로 보여주기
```
    int count1 = random.nextInt(5)+1;
    int count2 = random.nextInt(5)+1;
    int count3 = random.nextInt(5)+1;

```
처음에는 swith문을 써서 이렇게 random 함수로 난수를 생성해 랜덤으로 보여주었다. </br>
그러나 필터링을 한 값을 switch문에 넣어야 했기 때문에 다른 함수를 사용하였다.
```
if(list1 != null){
            Collections.shuffle(list1);
        }
```
이게 결정적으로 내가 배열을 ArrayList로 바꾼 이유이다. 배열은 shuffle()이 안되더라...라는 것이다. </br>
아무튼 이렇게 필터링도 하고 열심히 섞어주었으니 switch문으로 음식을 선정해주기만 하면 된다.
```
cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (list1.get(0)){
                    case "1" :
                        Intent intent1 = new Intent(getApplicationContext(), meatball.class);
                        startActivity(intent1);
                        break;
                    case "2" :
                        Intent intent2 = new Intent(getApplicationContext(), chickennugget.class);
                        startActivity(intent2);
                        break;
                    case "3" :
                        Intent intent3 = new Intent(getApplicationContext(), budaestew.class);
                        startActivity(intent3);
                        break;
                    case "4" :
                        Intent intent4 = new Intent(getApplicationContext(), red_bulgogi.class);
                        startActivity(intent4);
                        break;
                    case "5" :
                        Intent intent5 = new Intent(getApplicationContext(), kimchi_fried_rice.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
 ```
 
 - 이렇게 구현하니까 추가적으로 내가 가진 레시피들중 먹을 수 있는게 없을 경우를 표시하는 것이 쉬웠다. </br>
```
@Override
            public void onClick(View view) {
                if(list3.isEmpty()){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CategoryChoice.this);
                    dlg.setTitle("레시피를 찾을 수가 없습니다");
                    dlg.setMessage("죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ");
                    dlg.setIcon(R.drawable.app_icon);
                    dlg.setPositiveButton("확인", null);
                    dlg.setNegativeButton("처음으로 돌아가기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent1);
                        }
                    });
                    dlg.show();
                    //Toast.makeText(getApplicationContext(),"죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ",Toast.LENGTH_SHORT).show();
                }else{
                ...
  ```
  이런 식으로 list가 비었는지 확인하면 된다. </br>
  처음에는 list != null 이렇게 조건문을 주었는데 ArrayList가 비었는지 확인할 때는 isEmpty()를 사용해야 했었다.

 
 ***
 
 
 #### 2.3.4 음식 추천 화면
 <img src = "https://user-images.githubusercontent.com/78638427/144748095-1b1e3fa2-390e-4dd3-a31c-4cfda29eaf1a.png" width = "270" height="480"></br>
> 테마를 선택하면 랜덤으로 각 테마별 5개의 음식 중 1개가 랜덤으로 비춰지는 화면이다. </br>
> 솔직히 서버로다가 데이터 몰아놓고 안드로이드에 쏴주는거 하고 싶었는데 처음에 삽질을 너무 많이 하고 앱을 처음 만드는 거다 보니 헤매서 시간을 다 잡아 먹어 할 수가 없었다.
> 이게 크게 아쉬운 점이다.</br>
> 원래는 각 테마별로 음식 10개정도 해서 총 30개 레시피 찾아놨는데 일일이 java랑 xml파일을 다 만들고 있으니까 힘들어서 15개밖에 못했다. </br>
> 앱을 보완한다면 서버에서 데이터를 쏘아서 이번처럼 일일이 전부 파일을 만드는 수고는 덜이는 것으로 가장 먼저 고치고 싶은 부분이다. </br>

***
 
#### 2.3.5 레시피화면과 음료 추천 화면
<img src = "https://user-images.githubusercontent.com/78638427/144748330-4b98c6ee-fa43-4c6f-980f-0baa05998316.png" width = "270" height="480">
<img src = "https://user-images.githubusercontent.com/78638427/144748347-04131c0c-92a5-4705-a85f-0db00d3a208e.png" width = "270" height="480"> </br>

수업시간에 배운거는 tabHost였는데 나는 tabLayout을 썼다. </br>
이유는 이게 더 있어 보이기도 했고 수업시간에 안 배운것을 써보고 싶었다. 그리고 이상하게 tabHost를 쓰려고 하니까 동작을 안해서 그냥 새로운거 써봐야지 하고 tabLayout을 사용하여 탭을 구현하였다.
```
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }
        });
```
tablayout이 원래 화룡정점은 fragment를 이용해서 tab이랑 붙여주는 것일텐데 이 부분을 나는 생략했다. </br>
다시 공부해야할 부분이다. 아무리 블로그를 뒤져봐도 뭐 어떻게 하라는 건지 몰라서 그냥 저렇게 위치를 changeView함수로 받아서 frame 단위로 setvisibility를 설정해 tab에 따라 보이고 안보이고를 설정했다.
```
private void changeView(int index){
        switch (index) {
            case 0:
                frame1.setVisibility(View.VISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                text.setVisibility(View.VISIBLE);
                break;
            case 1:
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                break;
        }
    }
```
> 이상하게 switch문을 많이 쓰게 되는 거 같다.

##### 구글 지도 API
<img src = "https://user-images.githubusercontent.com/78638427/144748618-f8997884-bd5f-442f-8311-d6bed41952de.png" width = "300" height="289"></br>
가까운 마트 찾기 버튼을 누르면 구글 지도가 나온다.</br>
<img src = "https://user-images.githubusercontent.com/78638427/144748793-07ac9a5c-28a8-4d9d-8bca-49d8a33866c9.jpg" width = "270" height="480"></br>
마트가 분명 구글 API 문서에는 있는데 코드에 나오는 자동완성 리스트에는 없어서 편의점으로 대체한 것이 너무 아쉬웠다.

```
public void showPlaceInformation(LatLng location){
        mMap.clear();

        if(previous_marker != null){
            previous_marker.clear();
        }
        new NRPlaces.Builder().listener(CloserMart.this)
                .key("AIzaSyB5G7gNmbKq_hhqkW5W0CIsVF0LmPHrCJU")
                .latlng(location.latitude, location.longitude) //현재 위치 받기
                .radius(500) //500m 내에서 검색
                .type(PlaceType.CONVENIENCE_STORE) //편의점 찾기
                .build().execute();
    }
```

##### 북마크 기능
![다운로드](https://user-images.githubusercontent.com/78638427/144749320-70e5270f-f813-43d6-add1-cd0a61531397.png)
</br>
> 여기서 개고생했다.
> 연동하는데만 일주일 걸린 것 같은데 지도 API 설정이랑 뭐가 자꾸 충돌이 나는지 계속 데이터베이스가 연동이 안되고 AVD가 팅겼다.
> 파이버베이스는 이번에 처음 사용해봐서 내가 연동을 잘못한 것인가 싶어 일주일동안 계속 다시 만들고 연동하고 다시 만들고 연동하고를 반복했던것 같다.
> 결국 해결은 구글 API를 쓰기 전 파일들로 다시 연동을 시도한 후에야 파이어베이스 데이터베이스에 접근할 수 있었다.
> log를 계속 읽다가 구글지도랑 자꾸 충돌이 일어나는 것 같아 보여 그냥 이렇게 했는데 되가지고 왜 안되었는지 정확한 이유는 아직도 잘 모르겠다.
>> 아무튼 파이어베이스 데이터베이스를 먼저 연동하고 구글 지도 API를 가져다 쓰니 두 기능 모두 잘 작동하였다.

데이터는 그냥 일일이 다 넣어주었다.
```
bookmark_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    writeData("l003","계란장닭가슴살덮밥","https://firebasestorage.googleapis.com/v0/b/androidproject-9def8.appspot.com/o/eggjang.jpg?alt=media&token=f7555c1f-4e22-42eb-becd-f2b10a8a40d9");
                    Toast.makeText(getApplicationContext(),"저장되었습니다!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    //Toast.makeText(getApplicationContext(), e.toString() ,Toast.LENGTH_LONG).show();
                }
            }
        });
 ```
데이터를 쓰는 writeData 함수는 따로 선언해준 함수이다.

```
public void writeData(String foodID, String foodName, String foodImg){
        bookMark bookmark = new bookMark(foodID, foodName, foodImg);
        databaseReference.child("BookMark").child("Food_05").setValue(bookmark);
    }
```
***

#### 2.3.6 recyclerView를 이용해 저장한 데이터 보여주기
<img src = "https://user-images.githubusercontent.com/78638427/144749367-890f9969-48e9-41ba-a23d-26f71f5e921d.png" width = "270" height="480"></br>
> 솔직히 이번 앱 만들면서 제일 어려웠던게 뭐냐고 하면 얘랑 같이 파이어베이스를 쓰는거라 할 수 있을거 같다.
</br>
recyclerView를 사용하기 위해서는 3개의 class가 필요하다.</br>

1. 하나는 내가 데이터베이스에 저장하고 가져오는 변수이름과 함수들을 가진 class.
>  이거는 그냥 몽고DB 사용할때 node.js에서 디비짜는거랑 비슷한 느낌이라고 내 마음대로 이해해버렸다.
2. 둘은 내가 recylerView를 통해 list로 보여줄 화면과 연동한 class
3. 셋은 1과 2를 이어줄 adapter class 이다.

</br>

###### bookMark.class
```
public class bookMark {
    public String foodName;
    public String foodID;
    public String foodImg;


    public bookMark(){}

    public String getFoodImg(){return foodImg;}

    public String getFoodName(){return foodName;}

    public String getFoodID(){return foodID;}

    public bookMark(String foodID, String foodName, String foodImg) {
        this.foodName = foodName;
        this.foodID = foodID;
        this.foodImg = foodImg;
    }
}
```
###### CustomAdapter.class
```
public CustomAdapter(ArrayList<bookMark> arrayList, StoreRecipe storeRecipe){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getFoodImg())
                .into(holder.tv_foodImg);
        holder.tv_foodName.setText(arrayList.get(position).getFoodName());
        @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_foodImg;
        TextView tv_foodName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_foodImg = itemView.findViewById(R.id.tv_foodImg);
            this.tv_foodName = itemView.findViewById(R.id.tv_foodName);
        }
    }
```
###### StoreRecipe.class
```
database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("BookMark");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    bookMark bookmark = snapshot1.getValue(bookMark.class);
                    arrayList.add(bookmark);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("StoreRecipe", String.valueOf(error.toException()));
            }
        });
```
이렇게랑 xml 파일은 리사이클러뷰리스트 보여주는 xml파일이랑 안에 list item으로 넣어줄 xml 파일 두개 만들어주면된다. </br>
솔직히 이렇게 복잡할 것 같았으면 그냥 리스트 뷰 썼다. </br>
그냥 리스트뷰 상위호환이라고 하길래 쓰고 싶어서 썼는데 초심자가 도전하기에는 다루기가 까다로운 부분이 상당히 많았다. </br>
왜냐하면 저것만 쓰면 리스트가 드래그로 밑에 내렸다가 다시 올리면 간격이 조절이 안되고 화면에 item들이 밀린다. 자세히 말하자면 하나의 layout에 아이템이 하나만 보이고 그게 연속적으로 이어져서 나타난다고 생각하면 된다. </br>
- 아무튼 문제점은 RecyclerDecoration_Height class를 추가해줌으로서 해결하였다.
```
DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        RecyclerDecoration_Height decoration_height = new RecyclerDecoration_Height(20);
        recyclerView.addItemDecoration(decoration_height);
 ```
 ```
 public class RecyclerDecoration_Height extends RecyclerView.ItemDecoration{
        private final int divHeight;

        public RecyclerDecoration_Height(int divHeight){
            this.divHeight = divHeight;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
            super.getItemOffsets(outRect, view, parent, state);
            if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()-1){
                outRect.bottom = divHeight;
            }
        }
    }
```
이렇게 추가하니까 깔끔하게 보였다. 

***
## 3. 앱 개선점
### 3.1 앱 UX/UI 개선점
1. flutter를 이용해서 좀더 예쁘게 디자인을 하고 싶어졌다.
> 동기한테 너무 디자인 구리다고 극딜 먹었다.
> 나도 이쁘게 하고 싶었는데 이게 현재 나에게 최선이었다.

2. 디자인이나 사용자 편의성은 거의 고려하지 않은게 티가 났다.
> 어쨌든 수정하고 싶다.

3. 사진 크기가 너무 제각각이라 보이는게 너무 다르다.
> 사진을 좀더 잘 찾았어야 하는데 생각보다 관련 음식 사진이 많이 없는게 좀 있었다.
>> 이런건 어떻게 하지?

### 3.1 앱 기능 개선점
> 할 말이 진짜 많은 부분이다.
1. 데이터베이스를 제대로 활용하지 못했다.
>> 데이터베이스에 레시피들을 전부 저장하고 앱에서 가져오는 형태를 취하고 레시피 저장은 인터넷이 연결이 안되도 볼수 있게 로컬 디바이스에 저장을 해야하는데 나는 그 반대로 기능을 구현해버렸다.
>> 바꿔야 하는 부분이다.

2. 저장한 레시피 보는 부분 기능을 제대로 구현하지 못했다.
>> 리사이클러뷰로여주는 것까지는 어찌저찌 했는데 위에서 보여준 삭제버튼이 동작을 하지 못했다.
>> 정확히 말하면 화면에서는 삭제가 하나씩 잘 됬는데 데이터베이스에서 지워지지를 않아서 도르마무였다.
그래서 일단 급한 대로 구현한 방법이 다음과 같이 그냥 한꺼번에 삭제하는 기능이었다.</br>
<img src = "https://user-images.githubusercontent.com/78638427/144750424-cbcc68cf-95bd-47d3-b946-b89fee856a14.png" width = "270" height="480"></br>

        
