/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.US;
import models.SP;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result choose() {
        return Results.html().template("views/AcesUp/index.html");
    }

    public Result acesUp() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }

    public Result acesUp1() {
        return Results.html().template("views/AcesUp/AcesUp_spanish.flt.html");
    }

    public Result gameGet(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealFour();

        return Results.json().render(g);
    }
    //gameget for US ACEUP
    public Result gameGet1(){
        US s = new US();
        s.buildDeck2();
        s.shuffle();
        s.dealFour();

        return Results.json().render(s);
    }

    //gameget for SP ACEUP
    public Result gameGet2(){
        SP s1 = new SP();
        s1.buildDeck1();
        s1.shuffle();
        s1.dealFour();

        return Results.json().render(s1);
    }

    public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        return Results.json().render(g);
    }

    //dealPost for US ACEUP
    public Result dealPost1(Context context, US s) {
        if(context.getRequestPath().contains("deal")){
            s.dealFour();
        }
        return Results.json().render(s);
    }

    //dealPost for SP ACEUP
    public Result dealPost2(Context context, SP s1) {
        if(context.getRequestPath().contains("deal")){
            s1.dealFour();
        }
        return Results.json().render(s1);
    }

    public Result removeCard(Context context, @PathParam("column") int colNumber, Game g){
        g.remove(colNumber);
        return  Results.json().render(g);
    }

    public Result removeCard1(Context context, @PathParam("column") int colNumber, US s){
        s.remove(colNumber);
        return  Results.json().render(s);
    }

    public Result removeCard2(Context context, @PathParam("column") int colNumber, SP s1){
        s1.remove(colNumber);
        return  Results.json().render(s1);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game g){
        g.move(colFrom,colTo);
        return  Results.json().render(g);
    }

    public Result moveCard1(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, US s){
        s.move(colFrom,colTo);
        return  Results.json().render(s);
    }

    public Result moveCard2(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, SP s1){
        s1.move(colFrom,colTo);
        return  Results.json().render(s1);
    }

}
