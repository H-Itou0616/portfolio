import tkinter as tk
import tkinter.ttk as ttk
import random
import math
from tkinter import messagebox as mb

#--------------------------------------#
#チーム分け用ツール
#メンバー数とチーム数からランダムにメンバーを割り振る
#--------------------------------------#


root=tk.Tk()
root.geometry("500x800")
root.title("Division Into Teams")

team_num=[2,3,4,5,6,7,8,9,10]

global result_length

def divide_event():
    global result_length
    result_tf.delete("1.0","end")

    #テキストフィールドから取得
    result_text=member_tf.get("1.0","end")
    #print(result_text)

    #改行で区切ってリストに入れる
    split_result=result_text.split("\n")
    #最後に空の要素があるので取り除く
    split_result_remove=list(filter(None,split_result))

    #リストの要素数の確認
    result_length=(len(split_result)-1)

    #重複なしランダムな整数をリストに入れる
    index_list=rand_ints_nodup(0,result_length-1,result_length)

    #ランダムな整数を使ってメンバー名のリストを表示する
    last_result=[]
    for i in range(result_length):
        last_result.append(split_result_remove[index_list[i]])
        
    #改行挿入
    last_result2=[]
    for i in range(result_length):
        last_result2="\n".join(last_result)

    #チーム分けの処理
    #チーム数取得
    num=team_cb.get()

    #1チーム当たりの最低メンバー数
    member_num=math.floor(int(result_length)/int(num))

    #余りのメンバー
    member_surplus=math.floor(int(result_length)%int(num))
    
    count=0
    team=[]
    #チーム数と人数が同じだった場合
    if int(result_length)==int(num):
        mb.showerror("警告","チームを分ける必要がありません。")
        
    #チーム分け用のループ
    for i in range(int(num)):
        team_tentative=[]

        for j in range(member_num):
            if int(len(team_tentative))<count:
                team_tentative.append(last_result[count])
                count+=1

                #奇数処理
                if i==int(num)-1 and j==int(member_num)-1 and int(member_surplus)!=0:
                    team_tentative.append(last_result[count])

                #偶数処理
                elif i==int(num) and j==int(member_num) and int(member_surplus)==0:
                    team_tentative.append(last_result[count])

            elif int(len(team_tentative))>=count:
                j=j+member_num
                team_tentative.append(last_result[count])
                count+=1
                
        team.append(team_tentative)

    #結果表示
    for i in range(int(num)):
        result_tf.insert("end","チーム")
        result_tf.insert("end",i+1)
        result_tf.insert("end","のメンバーは\n")

        for j in range(len(team[i])):
            result_tf.insert("end","・")
            result_tf.insert("end",team[i][j])
            result_tf.insert("end","\n")
        result_tf.insert("end","\n")


#重複のない乱数生成    
def rand_ints_nodup(a,b,k):
    global result_length
    ns=[]
    while len(ns)<k:
        n=random.randint(a,b)
        if not n in ns:
            ns.append(n)
    return ns

#ラベルなど
title_lb=tk.Label(root,text="Division Into Teams",font=("",25))
title_lb.place(x=100,y=40)

member_lb=tk.Label(root,text="メンバー入力欄",font=("",15,"bold"))
member_lb.place(x=50,y=90)

team_lb=tk.Label(root,text="チーム名入力欄",font=("",15,"bold"))
team_lb.place(x=300,y=90)

member_tf=tk.Text(font=("",15,"bold"))
member_tf.place(x=25,y=120,width=200,height=200)

team_tf=tk.Text()
team_tf.place(x=275,y=120,width=200,height=200)

result_lb=tk.Label(root,text="結果",font=("",17))
result_lb.place(x=20,y=340)

result_tf=tk.Text(font=("",15,"bold"))
result_tf.place(x=20,y=370,width=220,height=300)

divide_btn=tk.Button(root,text="分ける",font=("",17),command=divide_event)
divide_btn.place(x=20,y=700)

teamnum_lb=tk.Label(root,text="チーム数",font=("",17))
teamnum_lb.place(x=270,y=340)

team_cb=ttk.Combobox(root,values=team_num,font=("",15,"bold"),width=10)
team_cb.place(x=275,y=370)

root.mainloop()
