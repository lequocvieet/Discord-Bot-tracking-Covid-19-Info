--
-- PostgreSQL database dump
--

-- Dumped from database version 12.10 (Ubuntu 12.10-1.pgdg20.04+1)
-- Dumped by pg_dump version 12.10 (Ubuntu 12.10-1.pgdg20.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: country_code; Type: TABLE; Schema: public; Owner: vieet
--

CREATE TABLE public.country_code (
    id integer NOT NULL,
    code character varying(255),
    country_name character varying(255)
);


ALTER TABLE public.country_code OWNER TO vieet;

--
-- Name: country_code_id_seq; Type: SEQUENCE; Schema: public; Owner: vieet
--

ALTER TABLE public.country_code ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.country_code_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: country_code; Type: TABLE DATA; Schema: public; Owner: vieet
--

COPY public.country_code (id, code, country_name) FROM stdin;
1	ad	Andorra
2	ae	United Arab Emirates
3	af	Afghanistan
4	ag	Antigua and Barbuda
5	ai	Anguilla
6	al	Albania
7	am	Armenia
8	ao	Angola
9	aq	Antarctica
10	ar	Argentina
11	as	American Samoa
12	at	Austria
13	au	Australia
14	aw	Aruba
15	ax	Åland Islands
16	az	Azerbaijan
17	ba	Bosnia and Herzegovina
18	bb	Barbados
19	bd	Bangladesh
20	be	Belgium
21	bf	Burkina Faso
22	bg	Bulgaria
23	bh	Bahrain
24	bi	Burundi
25	bj	Benin
26	bl	Saint Barthélemy
27	bm	Bermuda
28	bn	Brunei
29	bo	Bolivia
30	bq	Caribbean Netherlands
31	br	Brazil
32	bs	Bahamas
33	bt	Bhutan
34	bv	Bouvet Island
35	bw	Botswana
36	by	Belarus
37	bz	Belize
38	ca	Canada
39	cc	Cocos (Keeling) Islands
40	cd	DR Congo
41	cf	Central African Republic
42	cg	Republic of the Congo
43	ch	Switzerland
44	ci	Côte d'Ivoire (Ivory Coast)
45	ck	Cook Islands
46	cl	Chile
47	cm	Cameroon
48	cn	China
49	co	Colombia
50	cr	Costa Rica
51	cu	Cuba
52	cv	Cape Verde
53	cw	Curaçao
54	cx	Christmas Island
55	cy	Cyprus
56	cz	Czechia
57	de	Germany
58	dj	Djibouti
59	dk	Denmark
60	dm	Dominica
61	do	Dominican Republic
62	dz	Algeria
63	ec	Ecuador
64	ee	Estonia
65	eg	Egypt
66	eh	Western Sahara
67	er	Eritrea
68	es	Spain
69	et	Ethiopia
70	eu	European Union
71	fi	Finland
72	fj	Fiji
73	fk	Falkland Islands
74	fm	Micronesia
75	fo	Faroe Islands
76	fr	France
77	ga	Gabon
78	gb	United Kingdom
79	gb-eng	England
80	gb-nir	Northern Ireland
81	gb-sct	Scotland
82	gb-wls	Wales
83	gd	Grenada
84	ge	Georgia
85	gf	French Guiana
86	gg	Guernsey
87	gh	Ghana
88	gi	Gibraltar
89	gl	Greenland
90	gm	Gambia
91	gn	Guinea
92	gp	Guadeloupe
93	gq	Equatorial Guinea
94	gr	Greece
95	gs	South Georgia
96	gt	Guatemala
97	gu	Guam
98	gw	Guinea-Bissau
99	gy	Guyana
100	hk	Hong Kong
101	hm	Heard Island and McDonald Islands
102	hn	Honduras
103	hr	Croatia
104	ht	Haiti
105	hu	Hungary
106	id	Indonesia
107	ie	Ireland
108	il	Israel
109	im	Isle of Man
110	in	India
111	io	British Indian Ocean Territory
112	iq	Iraq
113	ir	Iran
114	is	Iceland
115	it	Italy
116	je	Jersey
117	jm	Jamaica
118	jo	Jordan
119	jp	Japan
120	ke	Kenya
121	kg	Kyrgyzstan
122	kh	Cambodia
123	ki	Kiribati
124	km	Comoros
125	kn	Saint Kitts and Nevis
126	kp	North Korea
127	kr	South Korea
128	kw	Kuwait
129	ky	Cayman Islands
130	kz	Kazakhstan
131	la	Laos
132	lb	Lebanon
133	lc	Saint Lucia
134	li	Liechtenstein
135	lk	Sri Lanka
136	lr	Liberia
137	ls	Lesotho
138	lt	Lithuania
139	lu	Luxembourg
140	lv	Latvia
141	ly	Libya
142	ma	Morocco
143	mc	Monaco
144	md	Moldova
145	me	Montenegro
146	mf	Saint Martin
147	mg	Madagascar
148	mh	Marshall Islands
149	mk	North Macedonia
150	ml	Mali
151	mm	Myanmar
152	mn	Mongolia
153	mo	Macau
154	mp	Northern Mariana Islands
155	mq	Martinique
156	mr	Mauritania
157	ms	Montserrat
158	mt	Malta
159	mu	Mauritius
160	mv	Maldives
161	mw	Malawi
162	mx	Mexico
163	my	Malaysia
164	mz	Mozambique
165	na	Namibia
166	nc	New Caledonia
167	ne	Niger
168	nf	Norfolk Island
169	ng	Nigeria
170	ni	Nicaragua
171	nl	Netherlands
172	no	Norway
173	np	Nepal
174	nr	Nauru
175	nu	Niue
176	nz	New Zealand
177	om	Oman
178	pa	Panama
179	pe	Peru
180	pf	French Polynesia
181	pg	Papua New Guinea
182	ph	Philippines
183	pk	Pakistan
184	pl	Poland
185	pm	Saint Pierre and Miquelon
186	pn	Pitcairn Islands
187	pr	Puerto Rico
188	ps	Palestine
189	pt	Portugal
190	pw	Palau
191	py	Paraguay
192	qa	Qatar
193	re	Réunion
194	ro	Romania
195	rs	Serbia
196	ru	Russia
197	rw	Rwanda
198	sa	Saudi Arabia
199	sb	Solomon Islands
200	sc	Seychelles
201	sd	Sudan
202	se	Sweden
203	sg	Singapore
204	sh	Saint Helena, Ascension and Tristan da Cunha
205	si	Slovenia
206	sj	Svalbard and Jan Mayen
207	sk	Slovakia
208	sl	Sierra Leone
209	sm	San Marino
210	sn	Senegal
211	so	Somalia
212	sr	Suriname
213	ss	South Sudan
214	st	São Tomé and Príncipe
215	sv	El Salvador
216	sx	Sint Maarten
217	sy	Syria
218	sz	Eswatini (Swaziland)
219	tc	Turks and Caicos Islands
220	td	Chad
221	tf	French Southern and Antarctic Lands
222	tg	Togo
223	th	Thailand
224	tj	Tajikistan
225	tk	Tokelau
226	tl	Timor-Leste
227	tm	Turkmenistan
228	tn	Tunisia
229	to	Tonga
230	tr	Turkey
231	tt	Trinidad and Tobago
232	tv	Tuvalu
233	tw	Taiwan
234	tz	Tanzania
235	ua	Ukraine
236	ug	Uganda
237	um	United States Minor Outlying Islands
238	un	United Nations
239	us	United States
240	us-ak	Alaska
241	us-al	Alabama
242	us-ar	Arkansas
243	us-az	Arizona
244	us-ca	California
245	us-co	Colorado
246	us-ct	Connecticut
247	us-de	Delaware
248	us-fl	Florida
249	us-ga	Georgia
250	us-hi	Hawaii
251	us-ia	Iowa
252	us-id	Idaho
253	us-il	Illinois
254	us-in	Indiana
255	us-ks	Kansas
256	us-ky	Kentucky
257	us-la	Louisiana
258	us-ma	Massachusetts
259	us-md	Maryland
260	us-me	Maine
261	us-mi	Michigan
262	us-mn	Minnesota
263	us-mo	Missouri
264	us-ms	Mississippi
265	us-mt	Montana
266	us-nc	North Carolina
267	us-nd	North Dakota
268	us-ne	Nebraska
269	us-nh	New Hampshire
270	us-nj	New Jersey
271	us-nm	New Mexico
272	us-nv	Nevada
273	us-ny	New York
274	us-oh	Ohio
275	us-ok	Oklahoma
276	us-or	Oregon
277	us-pa	Pennsylvania
278	us-ri	Rhode Island
279	us-sc	South Carolina
280	us-sd	South Dakota
281	us-tn	Tennessee
282	us-tx	Texas
283	us-ut	Utah
284	us-va	Virginia
285	us-vt	Vermont
286	us-wa	Washington
287	us-wi	Wisconsin
288	us-wv	West Virginia
289	us-wy	Wyoming
290	uy	Uruguay
291	uz	Uzbekistan
292	va	Vatican City (Holy See)
293	vc	Saint Vincent and the Grenadines
294	ve	Venezuela
295	vg	British Virgin Islands
296	vi	United States Virgin Islands
297	vn	Vietnam
298	vu	Vanuatu
299	wf	Wallis and Futuna
300	ws	Samoa
301	xk	Kosovo
302	ye	Yemen
303	yt	Mayotte
304	za	South Africa
305	zm	Zambia
306	zw	Zimbabwe
\.


--
-- Name: country_code_id_seq; Type: SEQUENCE SET; Schema: public; Owner: vieet
--

SELECT pg_catalog.setval('public.country_code_id_seq', 306, true);


--
-- Name: country_code country_code_pkey; Type: CONSTRAINT; Schema: public; Owner: vieet
--

ALTER TABLE ONLY public.country_code
    ADD CONSTRAINT country_code_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

