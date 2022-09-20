package com.ummaaack.halueumpyo.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.annotations.SerializedName
import com.ummaaack.halueumpyo.data.remote.model.RequestSignUpData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository,
) : ViewModel() {

    private val _diaryList = MutableLiveData<List<ResponseGetDiary.Data>>()
    val diaryList: LiveData<List<ResponseGetDiary.Data>> = _diaryList

    private val _getDiaryListSuccess = MutableLiveData<Boolean>()
    val getDiaryListSuccess: LiveData<Boolean> = _getDiaryListSuccess


    fun getCalendar(date: String) {
        viewModelScope.launch {
            runCatching {
            //    calendarRepository.getDiary(date)
            }.onSuccess {
                _diaryList.value =
                    listOf(

                        ResponseGetDiary.Data(
                            id = 2,
                            content = "아침에 잠을 깨고 엄마한테 사랑한다고 말했다 나를 따라온 옆집 강아지 happy가 너무 귀여워서 행복했다. 세상에는 이렇게 행복하고 멋진 일도 많은 데 왜 어른들은 그런 걸 못 볼까? 어른 되면 후회도 많을 텐데 나는 그동안 열심히 내 자신을 찾아가야겠다 화이팅",
                            emotionId=2,
                            title="종이비행기 (Paper Plane)",
                            singer="NCT 127",
                            cover="https://cdnimg.melon.co.kr/cm/album/images/102/84/718/10284718_500.jpg?1dcdc464e3ad11c2fcdfa73cf33ae4c7/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=c-EynNRWwmg",
                            createdAt="2022-05-15 Fri"
                        ),
                        ResponseGetDiary.Data(
                            id = 3,
                            content = "휴 오늘 자괴감 장난이니 하루였다 맨날 시험공부 3주 전부터 하자고 다짐하고는 막상 하면 3일 전에 허겁지겁이지.. 그걸 지금 4년쨰 하고 있지..ㅋㅋㅋ 카페 가면 공부 잘될까 싶어서 갔다가 거기서 또 1시간 논 것 같다 그래도 앤트러사이트 커피는 맛있었다…",
                            emotionId=4,
                            title="310",
                            singer="백예린",
                            cover="https://cdnimg.melon.co.kr/cm2/album/images/103/62/776/10362776_20191210144641_500.jpg?72384ea6f2169ad829dd9450d2382fe3/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=d4eiB-nmIoo",
                            createdAt="2022-05-20 Sat"
                        ),
                      ResponseGetDiary.Data(
                            id = 4,
                            content = "오랜만에 가타카를 봤는데 이렇게 슬픈 영화인 줄 몰랐다... 빈센트도 빈센트지만 제롬의 끝을 보니 마음이 아렸다. 불빛이 반사되어 제롬의 은메달이 금메달처럼 보이는 장면에서 진짜 펑펑 울었던 것 같다. 처음엔 제롬의 선택이 너무 슬프고 충격적이었지만 그게 그가 자신만의 자유를 찾는 방식이었다는 리뷰를 봤을 때 그나마 위안이 좀 되었다.",
                            emotionId=2,
                            title="스물다섯, 스물하나",
                            singer="자우림",
                            cover="https://cdnimg.melon.co.kr/cm/album/images/026/63/424/2663424_500.jpg/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=TcytstV1_XE",
                            createdAt="2022-05-17 Sun"
                        ),
                        ResponseGetDiary.Data(
                            id = 5,
                            content = "새벽에 과제하려니까 진짜 새벽 감성으로 쓰는 것 같다 내일되면 많이 수정하겠지만 그래도 이런 감성에 맡겨서 쓰면 빨리 써지긴 한다...ㅋㅋㅋ 노래까지 축 처지니까 완전 더 그런 것 같다 일부러 Joy Crookes랑 Lianne La Havas 노래 찾아듣고 있다",
                            emotionId=6,
                            title="적외선 카메라",
                            singer="원슈타인",
                            cover="https://cdnimg.melon.co.kr/cm/album/images/102/84/718/10284718_500.jpg?1dcdc464e3ad11c2fcdfa73cf33ae4c7/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=c-EynNRWwmg",
                            createdAt="2022-05-08 Mon"
                        ),
                        ResponseGetDiary.Data(
                            id = 6,
                            content = "앗싸 내일 쉬는 날이다!!! 어차피 졸프하느라 학교 가는 거랑 안 가는 거랑 차이 없긴 하지만 그래도 공식적으로 안간다니까 더 기분이 좋다ㅋㅋㅋ 내일 투표 빨리 하고 맛있는 거 먹으러 가야겠다",
                            emotionId=1,
                            title="안녕, 여름밤",
                            singer="마인드유",
                            cover="https://cdnimg.melon.co.kr/cm2/album/images/103/62/776/10362776_20191210144641_500.jpg?72384ea6f2169ad829dd9450d2382fe3/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=d4eiB-nmIoo",
                            createdAt="2022-05-03 Fri"
                        ),
                        ResponseGetDiary.Data(
                            id = 7,
                            content = "와 오늘 지나가다가 비둘기랑 부딪힐 뻔했는데 비둘기가 사람도 안 피하고 눈 똑바로 보고 있어서 내가 쫄아서 비켰다... 요즘 비둘기들 진짜 무섭다",
                            emotionId=4,
                            title="너와 함께",
                            singer="정세운",
                            cover="https://cdnimg.melon.co.kr/cm/album/images/102/84/718/10284718_500.jpg?1dcdc464e3ad11c2fcdfa73cf33ae4c7/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=c-EynNRWwmg",
                            createdAt="2022-05-02 Sun"
                        ),
                        ResponseGetDiary.Data(
                            id =8,
                            content = "디폴트밸류가서 아인슈페너랑 바나나푸딩을 먹었다. 바나나푸딩은 역시 맛있었다. 그런데 에어컨을 너무 많이 틀어서 그런지 좀 추웠다. 나중에는 좀 체할 것 같이 추워져서 급히 밖으로 나왔다. 근데 또 밖에 나오니까 더워서 이게 무슨 일인가 싶었다.. 이게 이상기후인가?",
                            emotionId=1,
                            title="꽃마리",
                            singer="수지",
                            cover="https://cdnimg.melon.co.kr/cm2/album/images/103/62/776/10362776_20191210144641_500.jpg?72384ea6f2169ad829dd9450d2382fe3/melon/resize/500/quality/80/optimize",
                            url="https://www.youtube.com/watch?v=d4eiB-nmIoo",
                            createdAt="2022-05-08 Mon"
                        )
                    )
            }
        }
    }

    fun postSingUp() {
        viewModelScope.launch {
            runCatching {
                calendarRepository.postSignUp(RequestSignUpData("alalekqls22@naver.com", "김다빈", "03180318"))
            }.onSuccess {
                Log.e("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ", "${it}")
            }
        }
    }
}

/*ResponseSignUpData(status=201, success=true, message=회원 가입 성공,
data=Data(email=alalekqls22@naver.com, username=김다빈,
accessToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjQsImVtYWlsIjoiYWxhbGVrcWxzMjJAbmF2ZXIuY29tIiwiaWRGaXJlYmFzZSI6IkNwNkM2RkkzejNjcjliZ0FSRGQ1Y0pKcUh5czIiLCJpYXQiOjE2NTQ4NTA0NzMsImV4cCI6MTY1NjA2MDA3MywiaXNzIjoiaGFsdWV1bXB5byJ9.2jxZUwy2y9QLXYzWbLCszbvy2YJmwTeLPNc6VPRqOOw,
refreshToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NTQ4NTA0NzMsImV4cCI6MTY1NjA2MDA3MywiaXNzIjoiaGFsdWV1bXB5byJ9.gRoVetzwNRil0hW8UaBbSABBsA2IUBLB04FaK-PC-8c))*/


data class ResponseGetDiary(
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("id")
        var id: Int,
        @SerializedName("content")
        var content: String,
        @SerializedName("emotionId")
        var emotionId: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("singer")
        var singer: String,
        @SerializedName("cover")
        var cover: String,
        @SerializedName("url")
        var url: String,
        @SerializedName("createdAt")
        var createdAt: String
    ) : Serializable
}
