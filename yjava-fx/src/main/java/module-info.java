module cn.yjava.yjavafx {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
            
    opens cn.yjava.yjavafx to javafx.fxml;
    exports cn.yjava.yjavafx;
}