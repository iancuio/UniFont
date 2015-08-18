# UniFont
A small Android library which allows you to set the overall font in an XML/ViewGroup!

Tired of setting the typeFace for every view you want to change the font?

Now you can do it in one line of code!

# Getting started

First of all, you have to include **jCenter()** repository in your **build.gradle:**

```
repositories {
    jcenter()
}
```

Then, you need to add the following line to your **dependencies {}** in your **build.gradle:**

```
compile 'com.iancuio.libraries:unifont:1.01'
```

Now you're ready to use it! Now let's talk a bit about how to use it.

# Usage

To use **UniFont**, you have to add the following line of code to you **Activity/Fragment onCreate{}/onViewCreated{}:**

```
UniFont.with(context).initialize(ViewGroup/Container).setFont("YourFont.ttf").apply();
```

In your Activity **onCreate{}:**

```
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        UniFont.with(this).initialize(ViewGroup/Container).setFont("YourFont.ttf").apply();
    }
```

Or in your Fragment **onViewCreated{}:**

```
 @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        UniFont.with(getActivity()).initialize(ViewGroup/Container).setFont("YourFont.ttf").apply();
    }
```

Now let's explain it a bit.

**with(context)** - With this method you give the context to UniFont.

**initialize(ViewGroup/Container)** - With this method you give to UniFont the Layout/Container in which you want to set the font in.

**Example:**

If you want to set the font for the whole XML, you just have to give an ID to your top level Layout that contains all your views in that XML:

**layout.xml:**
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/container">

    <TextView
        android:id="@+id/layout_textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TEXT" />
        
    <TextView
        android:id="@+id/layout_textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TEXT" />
    
    <TextView
        android:id="@+id/layout_textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TEXT" />
        
</LinearLayout>
```

As you can see, I have set an ID to the LinearLayout that contains the TextViews.

```
android:id="@+id/container"
```

Now, I will define in my **Activity/Fragment** as any other view:

```
LinearLayout container = (LinearLayout) findViewById(R.id.container);
```

And set it to **UniFont:**

In your Activity **onCreate{}:**

```
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        UniFont.with(this).initialize(container).setFont("YourFont.ttf").apply();
    }
```

Or in your Fragment **onViewCreated{}:**

```
 @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        UniFont.with(getActivity()).initialize(container).setFont("YourFont.ttf").apply();
    }
```

**Additionally**, you can set the font for a sub-layout in your main layout:

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/container">

    <TextView
        android:id="@+id/layout_textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TEXT" />
        
      <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/subContainer">
        
        <TextView
          android:id="@+id/layout_textView1"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="TEXT" />
    
      <TextView
          android:id="@+id/layout_textView2"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="TEXT" />
          
    </LinearLayout>
        
</LinearLayout>
```

I have set an ID to the LinearLayout that contains the two TextViews.

```
android:id="@+id/subContainer"
```

You can do the same as earlier. The **"subContainer"** will have your set font, and the **"container"** will be left untouched.

```
UniFont.with(this/getActivity()).initialize(subContainer).setFont("YourFont.ttf").apply();
```

**Additionally additionally**, you can set the two or more different fonts for you main layout and the sub-layouts in your XML.
The font will be overwritten in the order of calling **UniFont:**

```
UniFont.with(this/getActivity()).initialize(container).setFont("OpenSansRegular.ttf").apply();
UniFont.with(this/getActivity()).initialize(subContainer).setFont("Kikelet.ttf").apply();
```

The **"container"** and all his children will have the "OpenSansRegular.ttf" font, but the **"subContainer"** will have "Kikelet.ttf" font, overriding the previous font. You can do that for any view in your chosen XML.

**setFont("YourFont.ttf")** - This sets the font you want to use in your chosen Container/Layout.

**IMPORTANT!!**

The font must be put under **assets/fonts** or else it will not work.

**Example:**

[fonts]https://cloud.githubusercontent.com/assets/13288065/9327167/94e73fe8-45a7-11e5-8b8b-cc384f37bed8.png

Now choose your desired font and set it to **UniFont:**(Here I will chose the "OpenSansRegular.ttf")

In your Activity **onCreate{}:**

```
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        UniFont.with(this).initialize(container).setFont("OpenSansRegular.ttf").apply();
    }
```

Or in your Fragment **onViewCreated{}:**

```
 @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        UniFont.with(getActivity()).initialize(container).setFont("OpenSansRegular.ttf").apply();
    }
```

**apply();** - This methos is pretty much self explanatory.

Now your font will be applied to your chosen Layout!

Hope it will be useful for you guys.

If you have any questions/critics/you name it, open an issue here or send it to my email: vlad@iancu.io

Cheers!








