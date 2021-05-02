package com.sas.delhibusnavigator;
import com.sas.delhibusnavigator.TourismActivity;
import com.sas.delhibusnavigator.R;
import com.sas.delhibusnavigator.TouchImageView;
import com.sas.delhibusnavigator.TourismActivity.ImageAdapter;

import android.app.Activity; 
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TourismActivity extends Activity {
	Integer[] pics = {R.drawable.akshardham_temple, R.drawable.ansal_plaza,
			R.drawable.appu_ghar, R.drawable.art_heritage, R.drawable.chandni_chowk,
			R.drawable.dilli_haat_ina, R.drawable.garhi_lalit_kala_artist_studio, 
			R.drawable.greater_kailash_market, R.drawable.gurudwara_bangla_sahib,
			R.drawable.humayun_tomb, R.drawable.india_gate,
			R.drawable.indira_gandhi_memorial, R.drawable.iskcon_temple,
			R.drawable.jama_masjid , R.drawable.jantar_mantar, 
			R.drawable.lodhi_garden , R.drawable.lotus_temple,
			R.drawable.national_zoological_park , R.drawable.nehru_park,
			R.drawable.parliament_house , R.drawable.pragati_maidan,
			R.drawable.purana_qila, R.drawable.qutab_minar ,
			R.drawable.raj_ghat, R.drawable.rajpath ,
			R.drawable.rashtrapati_bhavan,	R.drawable.red_fort,
			R.drawable.the_village_gallery, R.drawable.tibet_house };
	LinearLayout imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour);
		try {
			// InputStream in = (new URL("www.google.com").openStream());
		} catch (Exception e) {
			e.getMessage();
		}
		Gallery ga = (Gallery) findViewById(R.id.Gallery01);
		ga.setAdapter(new ImageAdapter(this));

		imageView = (LinearLayout) findViewById(R.id.ImageView01);
		ga.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				String details="";
				switch(arg2)
			  { case 0 : details="AKSHARDHAM TEMPLE \n\nDescription : The Akshardham constructed of recent times and was inaugurated temple Bochasanvasi Swaminarayan Sanstha " +
			  		    "on the banks of the River Yamuna, Open timings 9 am to 8 pm(Monday closed).The temple stretches over an area of 100 acres and was completed in two years." +
			  		    "This temple has awesome musical fountain which started in the evening. ";
			       break;
				case 1 : details="ANSAL PLAZA \n\nDescription : Ansal Plaza offers the customers a world class shopping experience located near South Extensio in South Delhi. " +
						"This huge plaza is built on 35 acres of land.An auditorium with a stage is located at the centre while the 45-feet high splendid Ansal Plaza is built around it." +
						" The Plaza has a French glass curtain wall that to keep away ultraviolet and other harmful radiation.";
		           break;
				case 2 : details="APPU GHAR \n\nDescription : Appu Ghar was an amusement park located in the Pragati Maidan in Delhi. This was the first amusement park of India, " +
						"and was inaugurated by Late Shri Rajiv Gandhi, who was the Prime Minister of India. Appu Ghar closed on 17th Feb 2008. Appu Ghar was opened on November 19, 1984 " +
						"and was named from the name 'Appu' which was the mascot of the 1982 Asian Games. It stretched over 15.5 acres of land. ";
		           break;
				case 3 : details="ART HERITAGE \n\nDescription : A respected name in the art world was founded in 1977 by Roshen Alkazi. The gallery holds regular exhibitions throughout " +
						"the year of some of the best known artists in India.205, Triveni Kala Sangam, Tansen Marg, New Delhi.Phone.:23718833. Timing: 11.00 am to 7.00 pm .";
		           break;
		        case 4 : details="CHANDNI CHOWK \n\nDescription : Chandni Chowk is one of the oldest market places that,it has still retained its charm.Chandni Chowk is located opposite the Red Fort. " +
		        		"At one end of the Chandni Chowk, one which Mosque, been built by the wives of Shah Jahan. At the other end of Chandni Chowk, is the old police station or the Kotwali.It is famous for shopping all types of goods";
		           break;
				case 5 : details="DILLI HAAT INA \n\nDescription : Dilli Haat stands for the variety Indian foods and customs in a single roomy enclosed space of six acres. A permanent and improvised " +
						"adaptation of a traditional village haat, it is actually a mixture of a food plaza and craft marketplace, located in the locality of South Delhi. ";
		           break;
		        case 6 : details="GARHI LALIT KALA ARTIST STUDIO \n\nDescription : It is a Place worth visiting place if you are interested in the live processes of art. This studio is a part of and is run, The Lalit Kala Academy. " +
		        		"Well known artists from India and abroad often hold workshops and illustrated lectures here.Kala Kutir, East of Kailash, New Delhi. Phone.:- 26432225 Timing: 10.00 am to 6.00 pm .";
		           break;
		        case 7 : details="GREATER KAILASH MARKET \n\nDescription : The Greater Kailash area of South Delhi has it all; lavish cozy homes, elegant dresses, brisk crowd and bountiful markets. " +
		        		"One of the most colorful and posh markets of Delhi, this place is a real paradise. Magnificent show rooms and retail outlets selling designer wears, restaurants & easy accessibility give the " +
		        		"Greater Kailash market the edge.";
		           break;
		        case 8 : details="GURUDWARA BANGLA SAHIB \n\nDescription : Gurudwara Bangla Sahib is located next to Gol Dak Khana near the Connaught Place. This place of Sikh worship is open to people of all faiths, castes or creeds. " +
		        		"The premises house a sacred pond in which devotees bathe. They believe that this would wash off their misdeeds and thus allow them to attain peace of mind.";
		           break;
		        case 9 : details="HUMAYUN TOMB \n\nDescription :It is located near the crossing of Mathura road and Lodhi road, this magnificent garden tomb is the first substantial example of Mughal architecture in India." +
		        		"It was built in 1565 A.D. nine years after the death of Humayun, by his senior widow Bega Begam. Inside the walled enclosure the most notable features are the garden squares (chaharbagh) with pathways water channels.";
		           break;
		        case 10 : details="INDIA GATE \n\nDescription : At the centre of New Delhi stands the 42 m Triomphe like archway in the middle of a crossroad.It commemorates the 70,000 peoples fighting for the British Army during the World War I. " +
		        		"The memorial bears the names of more than 13,516 British and Indian soldiers killed in the Northwestern war of 1919. The monument was dedicated to the nation and known by Amar Jawan Jyoti";
		           break;
		        case 11 : details="INDIRA GANDHI MEMORIAL \n\nDescription : Indira Gandhi Memorial Museum was the residence of the former Prime Minister of India. It was later converted into a museum. " +
		        		"One can see the collection of rare photographs of the Nationalist movement, the personal moments of the Nehru-Gandhi family and her childhood. Location : No. 1, Safderjang Road, New Delhi- 110 011. Timing: 9.30am To 5:00 pm Closed: Monday.";
		           break;
		        case 12 : details="ISKCON TEMPLE \n\nDescription : The ISKCON Temple is located at Hare Krishna Hill, Sant Nagar, East of Kailash,New Delhi,DL-110065. Phone.:- 011-26235133 and was completed in 1998 as a complex of temples. " +
		        		"This temple has been built on a hilly terrain and is dedicated to the Lord Krishna. A great sense of calm, stillness envelope you once you enter the premises. Many spiritual activities are carried out in the temple premises throughout the year.";
		           break;
		        case 13 : details="JAMA MASJID \n\nDescription : Jama Masjid,is located in Chandni Chowk, New Delhi, Phone.:-011-23365358 and it was commissioned to be constructed by the Mughal Emperor Shah Jahan. " +
		        		"It holds the distinction of being one of the biggest and the most well known mosque of Old Delhi. Due to its setting at a very prominent center in Old Delhi, a lot of visitors visit it right through the year. ";
		           break;
		        case 14 : details="JANTAR MANTAR \n\nDescription : Jantar Mantar is located at Sansad Marg, Janpath, Connaught Place,New Delhi,DL-110001 Phone:- 011-23365358 Open: All days ,Timings: 6:00 am – 7:00 pm Entry Fee: Rs.5(Indians),Rs.100(foreigners)." +
		        		"Jantar Mantar(jantra- instruments, mantra- formulae) was constrcted in 1724.";
		           break;
		        case 15 : details="LODHI GARDEN \n\nDescription : The Lodhi Gardens is a recreational area in Delhi,located at Amrita Shergill Ln, Lodhi Gardens, Lodi Estate, New Delhi,DL-110003 Timimg: 6.00 AM - 7.00 PM and situated between Khan Market and Safdarjung's Lodhi Road. " +
		        		"In the middle of Lodhi and Sayyid aristocratic beautiful gardens is the Bara Gumbad or the 'Big Dome' and Sheesh'mirror dome'";
		           break;
		        case 16 : details="LOTUS TEMPLE \n\nDescription : Lotus Temple is situated at Lotus Temple Rd, Shambhu Dayal Bagh, Bahapur, New Delhi, Delhi 110019 Pnone.:- 011-23389326 Timing: 9:30 am – 5:30 pm.It is incredible architectures of the faith.The temple has been constructed to resemble a lotus flower. " +
		        		"The huge lotus flower has been made out of marble, dolomite, cement, and sand.The place is known for its spotlessly clean environment.";
		           break;
		        case 17 : details="NATIONAL ZOOLOGICAL PARK \n\nDescription : It is located near the Old Fort,Mathura Rd, New Delhi,DL-110003 TIMINGS: 9:00am - 4:30pm  Monday closed, Entrance Fee:Indians: Rs.10(Adults), Rs.5(Children from 5-12 years) and Foreigners: Rs.50(Adults)." +
		        		"It is stretches across 214 acres of land.The park is home to several species of animals as well as various types of vegetation. It offers a natural environment to over 2,000 birds and animals";
		           break;
		        case 18 : details="NEHRU PARK \n\nDescription : Nehru Park, Delhi, is large park situated at Vinay Marg, Chanakyapuri Diplomatic Enclave of New Delhi, DL-110021. Named after India's first Prime Minister, " +
		        		"Jawaharlal Nehru, the park is spread over an area of 80 acres,close to the heart of the city, and was established in 1969.";
		           break;
		        case 19 : details="PARLIAMENT HOUSE \n\nDescription : The Parliament House is located at Lok Sabha Marg, Gokul Nagar,Pandit Pant Marg Area, Central Secretariat, New Delhi, DL-110001. " +
		        		"The Parliament House (Sansad Bhavan) is a circular building designed by the British architects Sir Edwin Lutyens and Sir Herbert Baker in 1912–1913";
		           break;
		        case 20 : details="PRAGATI MAIDAN \n\nDescription :It is loacted at Mathura Rd, Pragati Maidan New Delhi,DL-110002.It‎ is a venue for large exhibitions and conventions in New Delhi, " +
		        		"and with 72,000 sq. metres of exhibition space,it is Delhi's largest exhibition centre. It is owned and managed by India Trade Promotion Organization (ITPO), Govt. of India.";
		           break;
		        case 21 : details="PURANA QILA \n\nDescription : Purana Qila or the Old Fort is situated at Pragati Maidan,Mathura Rd,New Delhi,Delhi-110003 Phone:-011-23365358. Purana Quila standing stoically amidst wild greenery." +
		        		"Built on the site of the most ancient of the numerous cities of Delhi, Indraprastha, Purana Quila is roughly rectangular in shape having a circuit of nearly two kilometers.";
		           break;
		        case 22 : details="QUTAB MINAR \n\nDescription : Qutab Minar is located near Mehrauli,New Delhi Open Timimgs: 6:00 am – 6:00 pm.It is a soaring, 73 m-high tower of victory & is made of red sandstone and marble, " +
		        		"built in 1193 by Qutab-ud-din Aibak immediately after the defeat of Delhi's last Hindu kingdom. The tower has five distinct storeys, each marked by a projecting balcony and tapers from a 15 m diameter at the base to just 2.5 m at the top. ";
		        break;
		        case 23 : details="RAJ GHAT \n\nDescription : Raj Ghat is located on the banks of Yamuna River Open timimg: 5:30 am to 7 pm and was built as a cenotaph for honouring Mahatma Gandhi. There is a grave black marble podium at this site which is the spot of cremation of Mahatma Gandhi done on 31st January 1948";
		           break;
		        case 24 : details="RAJPATH \n\nDescription : RajPath is said commissioned India Gate and its surrounding area on Rajpath, RajRoad Open Timing: 12:00 AM - 12:00 PM. It is the traditional avenue of there public Indian Republic day parade passes every year. " +
		        		"It boasts of decorative parks, pools and gardens along extends from the India Gate to Vijay Chowk, and Bhavan and National Stadium at two opposite ends.";
		           break;
		        case 25 : details="RASHTRAPATI BHAVAN \n\nDescription : Rashtrapati Bhavan(Presidential Residence) is the official home of the President of India. It is situated in the Raisina Hills,Delhi Phone:- 011-23013287, open Timings 9:00am to 4:00pm(Fri-Sun). " +
		        		"It may refer to only the mansion (the 340-room main building) that has the President's official residence, halls, guest rooms and offices. The main palace building was formerly known as Viceroy's House.";
		           break;
		        case 26 : details="RED FORT \n\nDescription : The Red sandstone walls of massive Red Fort (Lal Qila) rise 33-m above the clamour of Old Delhi as a reminder of the magnificent power and emperors. The pomp of the Mughal walls, built in 1638. " +
		        		"The main gate, Lahore Gate, is one of the emotional and symbolic focal points of the modern Indian nation and on crowd major attracts Independence Day";
		           break;
		        case 27 : details="THE VILLAGE GALLERY \n\nDescription : This gallery has done innovative shows in graphic design, drawings and sketches by Satyajit Ray, Mono-rints by women inmates of Tihar Jail and Haku Shah's homage to Gandhiji with straw, " +
		        		"rags and cotton wool.14, Hauz Khas Village, New Delhi. Phone.: 26853860Timing: 10.30 am to 6.30 pm";
		           break;
		        case 28 : details="TIBET HOUSE \n\nDescription : The Tibet House is located at Lodhi Rd,Institutional Area,Lodi Colony,New Delhi,DL-110003 Phone:- 011-24611515 Open: 9:30 am To 5:30 pm Closed: Sat & Sun and is a brilliant information offering a quick picture of the Tibetan history. " +
		        		"The Museum of Tibet house, holds an assortment of Tibetan artifacts that brought to India by Dalai Lama, when he escaped from the Tibetan lands.";
		           break;
			  }
				
				Toast.makeText(getBaseContext(),details, Toast.LENGTH_SHORT).show();
				//Toast.makeText(getBaseContext(),"You have selected picture " + (arg2 + 1)
				//				+ " of Delhi", Toast.LENGTH_SHORT).show();
			
				try {
				imageView.removeAllViews();
				} catch (Exception e) {
					e.getMessage();
				}
				TouchImageView touchImageView = new TouchImageView(
						TourismActivity.this);
				touchImageView.setImageResource(pics[arg2]);
				LayoutParams lp=new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
				imageView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
				touchImageView.setLayoutParams(lp);
				imageView.addView(touchImageView);
			}

		});

	}

	public class ImageAdapter extends BaseAdapter {

		private Context ctx;
		int imageBackground;

		public ImageAdapter(Context c) {
			ctx = c;
			TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
			imageBackground = ta.getResourceId(
					R.styleable.Gallery1_android_galleryItemBackground, 1);
			ta.recycle();
		}

		@Override
		public int getCount() {

			return pics.length;
		}

		@Override
		public Object getItem(int arg0) {

			return arg0;
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ImageView iv = new ImageView(ctx);
			iv.setImageResource(pics[arg0]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(150, 120));
			iv.setBackgroundResource(imageBackground);
			return iv;
		}
	}


}
