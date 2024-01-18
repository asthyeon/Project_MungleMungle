import React, { useState, useEffect } from "react";
import "./PostPage.css";
import ProfileCircle from "../../components/ProfileCircle";
import axios from "axios";

import imgProfile1 from "../../assets/example/profile1.jpg";
import imgProfile2 from "../../assets/example/profile2.jpg";
import imgProfile3 from "../../assets/example/profile3.jpg";
import imgProfile4 from "../../assets/example/profile4.jpg";
import imgProfile5 from "../../assets/example/profile5.jpg";
import imgProfile6 from "../../assets/example/profile6.jpg";
import imgProfile7 from "../../assets/example/profile.png";

import imgPost1 from "../../assets/example/dog1.jpg"
import imgPost2 from "../../assets/example/dog2.jpg"
import imgPost3 from "../../assets/example/dog3.jpg"
import imgPost4 from "../../assets/example/dog4.jpg"
import imgPost5 from "../../assets/example/dog5.jpg"
import imgPost6 from "../../assets/example/dog6.jpg"
import imgPost7 from "../../assets/example/dog7.jpg"
import imgPost8 from "../../assets/example/dog8.jpg"
import imgPost9 from "../../assets/example/dog9.jpg"
import imgPost10 from "../../assets/example/dog10.jpg"

import iconRecommend from "../../assets/icons/recommend.png";
import iconFollow from "../../assets/icons/follow.png";
import ToggleButton from "../../components/button/ToggleButton";
import PostComponent from "../../components/Post/PostComponent";
import CreateButton from "../../components/button/CreateButton";

export default function Post() {
  // const [posts, setPosts] = useState([]);
  // const [recommendProfile, setRecommendProfile] = useState([]);

  // const getPostList = () => {
  //   axios.get('url')
  //     .then((res) => {
  //       console.log(res.data)
  //       setPosts(res.data)
  //     })
  //     .catch((err) => console.log(err))
  // }

  // useEffect(() => {
  //   getPostList()
  // }, []);

  const profiles = [
    {
      img: imgProfile1,
      name: "user1",
    },
    {
      img: imgProfile2,
      name: "user2",
    },
    {
      img: imgProfile3,
      name: "user3",
    },
    {
      img: imgProfile4,
      name: "user4",
    },
  ]

  const toggleButton = {
    img1: iconRecommend,
    text1: "추천",
    img2: iconFollow,
    text2: "팔로잉",
  };

  const profileList = profiles.
    map((profile, index) => {
      return (
        <ProfileCircle
          key={index}
          img={profile.img}
          name={profile.name}
        />
      );
  })

  const postList = [
    {
      user : {
        imgProfile: imgProfile1,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost1,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "코기", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile2,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost2,
      title: "애기랑 오랜만에 공원",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "아구", "힘들어?",
      ],
    },
    {
      user : {
        imgProfile: imgProfile3,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost3,
      title: "귀여워라",
      createdAt: "2024-01-17",
      tagList: [
        "신남", "댕글댕글",
      ],
    },
    {
      user : {
        imgProfile: imgProfile4,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost4,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile5,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost5,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile6,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost6,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile1,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost7,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile2,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost8,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile3,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost9,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
    {
      user : {
        imgProfile: imgProfile4,
        name: 'megar0829',
        isFollow: false,
      },
      imgPost: imgPost10,
      title: "산책하는 댕댕이",
      createdAt: "2024-01-17",
      tagList: [
        "산책", "댕댕이", "신났네",
      ],
    },
  ]


  return (
    <div className="post-container-div">
      <div className="post-top-div">
        <div className="post-top-div-top-div">
          <ToggleButton 
            img1={iconRecommend}
            text1="추천"
            img2={iconFollow}
            text2="팔로잉"
          />
        </div>
        <div className="post-top-div-bottom-div">
          {profileList}
        </div>
      </div>
      <div className="post-bottom-div">
        <PostComponent 
          postList={postList}
        />
      </div>
      <CreateButton />
    </div>
  );
}